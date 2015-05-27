package com.uniquesoft.gwt.server.service.common;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.uniquesoft.gwt.shared.DataBaseConstraintException;
import com.uniquesoft.gwt.shared.RemoteServiceException;
import com.uniquesoft.gwt.shared.SessionTimeOutException;

/**
 * The servlet class for UIDL GWT RPC service implementations that override the
 * processCall method handle the payload of request
 * 
 */
@SuppressWarnings("serial")
public class SpringGwtRemoteServiceServlet extends RemoteServiceServlet {

	private static final Log log = LogFactory
			.getLog(SpringGwtRemoteServiceServlet.class);

	/**
	 * Uses {@link ServiceUtils} to get the Service to handle the payload of the
	 * Request, and generate the payload of response.
	 */
	@Override
	public String processCall(String payload) throws SerializationException,
			SessionTimeOutException {
		RPCRequest rpcRequest = null;
		try {
			HttpServletRequest httpRequest = getThreadLocalRequest();
			HttpRequestThreadLocal.set(httpRequest);
			RemoteService service = ServiceUtils.getService(httpRequest);

			rpcRequest = com.google.gwt.user.server.rpc.RPC.decodeRequest(
					payload, service.getClass(), this);
			onAfterRequestDeserialized(rpcRequest);
			log.info("Invoking " + service + "#"
					+ rpcRequest.getMethod().getName());
			if (requireSession(rpcRequest) && !hasLogin()) {
				throw new SessionTimeOutException();
			}
			String response = com.google.gwt.user.server.rpc.RPC
					.invokeAndEncodeResponse(service, rpcRequest.getMethod(),
							rpcRequest.getParameters(),
							rpcRequest.getSerializationPolicy());
			log.info("finish");
			return response;

		} catch (RemoteServiceException e) {
			return com.google.gwt.user.server.rpc.RPC.encodeResponseForFailure(
					null, e);
		} catch (IncompatibleRemoteServiceException e) {
			return com.google.gwt.user.server.rpc.RPC.encodeResponseForFailure(
					null, e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			if (isDataIntegrityException((Exception) e)) {
				return com.google.gwt.user.server.rpc.RPC
						.encodeResponseForFailure(rpcRequest.getMethod(),
								new DataBaseConstraintException());
			} else if (e instanceof IsSerializable) {
				return com.google.gwt.user.server.rpc.RPC
						.encodeResponseForFailure(rpcRequest.getMethod(), e);
			} else {
				return com.google.gwt.user.server.rpc.RPC
						.encodeResponseForFailure(rpcRequest.getMethod(),
								new RemoteServiceException(e.getMessage()));

			}
		}
	}

	/**
	 * Always return true for whether require Session
	 * 
	 * @param rpcRequest
	 *            {@link RPCRequest}
	 * @return true
	 */
	protected boolean requireSession(RPCRequest rpcRequest) {
		return true;
	}

	/**
	 * Always return true for hasLogin
	 * 
	 * @return true
	 */
	protected boolean hasLogin() {
		return true;
	}

	/**
	 * Check the exception is type of {@link DataIntegrityViolationException}
	 * 
	 * @param e
	 *            {@link Exception}
	 * @return
	 */
	protected boolean isDataIntegrityException(Exception e) {
		Throwable curE = e;
		int level = 0;
		while (curE != null && level < 10) {
			if (curE.getClass().equals(DataIntegrityViolationException.class)
					|| curE.getClass().equals(
							ConstraintViolationException.class)) {
				return true;
			} else
				curE = curE.getCause();
			level++;
		}
		return false;
	}

}
