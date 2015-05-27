package edu.fudan.langlab.security.shared;

public class FunctionIdentifier implements IFunctionIdentifier {

	private String functionid;
	
	public FunctionIdentifier(){
		
	}

	public FunctionIdentifier(String functionid) {
		this.functionid = functionid;
	}
	
	@Override
	public String getIdentifier() {
		return functionid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((functionid == null) ? 0 : functionid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionIdentifier other = (FunctionIdentifier) obj;
		if (functionid == null) {
			if (other.functionid != null)
				return false;
		} else if (!functionid.equals(other.functionid))
			return false;
		return true;
	}

}
