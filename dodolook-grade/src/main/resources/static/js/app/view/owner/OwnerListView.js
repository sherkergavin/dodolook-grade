Ext.define('gwj.view.owner.OwnerListView',{
	extend:'Ext.grid.Panel',
	alias:'widget.ownerListViewByGWJ',
	id:'ownerListViewbyGWJ',
	initComponent:function(){
		var me = this;
		Ext.apply(me,{
			title:'人员总览',
			layout:'fit',
			defaults:{anchor:'100%'},
			autoScroll: true,
			anchor:'100%,100%',
			store:'owner.Owner_QueryGrid_List_Store',
			bodyStyle:"background-color: #a1afc9",
			selType: "cellmode",//多选按钮
			selModel:Ext.create('Ext.selection.CheckboxModel',{injectCheckbox :1,showHeaderCheckbox:false}), 
			columns:[
					{xtype:'rownumberer',width:80,align:'center',text:'序号'},
					{text:'姓 &nbsp;&nbsp;&nbsp;名',width:50, dataIndex:'ownerName', align:'center',menuDisabled: true,flex:.3},
					{text:'登录名',width:50, dataIndex:'loginName', align:'center',menuDisabled: true,flex:.3},
					{text:'工&nbsp;&nbsp;&nbsp;号',width:50, dataIndex:'workNum', align:'center',menuDisabled: true,flex:.3},
					{text:'时&nbsp;&nbsp;&nbsp;间',width:50, dataIndex:'createTime', align:'center',menuDisabled: true,flex:.3}
			],
			dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                items: [
                		{xtype:'button', text:'追  加',action:'add',icon:projectGP('/pic/add.gif')},
                		{xtype:'button', text:'编  辑',action:'edit',icon:projectGP('/pic/edit.gif')},
                		{xtype:'button', text:'刷  新',action:'reset',icon:projectGP('/pic/upload.gif')},
                		{xtype:'button', text:'删  除',action:'delete',icon:projectGP('/pic/clear.gif')}
                	   ]
            }]
		});
		
		me.callParent(arguments);
	}
});