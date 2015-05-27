delete from rcproductstoretransaction;
delete from rcproductstorage;

delete from rctransferrecorditem;
delete from rctransferrecord;

delete from rcproductentry;

delete from  rccomplaint;
delete from m2m_rcworkitemtask_workers;
delete from rcworkitemtask;
update rcrepairtask set activeGroupTask_id = null;
delete from rcgrouptask;
delete from rcrepairtask;

delete from rcinstockrecorditem;
delete from rcinstockrecord;

delete from rcworkitemstockrecorditem;
delete from rcworkitemstockrecord;
delete from rcproductwarehousestoragesummary;
