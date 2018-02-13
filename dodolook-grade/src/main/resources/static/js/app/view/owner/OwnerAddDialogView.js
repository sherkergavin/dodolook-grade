Ext.define('gwj.view.owner.OwnerAddDialogView',{
	extend:'Ext.window.Window',
	alias:'widget.ownerAddDialogViewByGWJ',
	id:'ownerAddDialogViewByGWJ',
	width:400,
    height:450,
   	resizable: false,
   	plain:true,
   	modal: true,
	closable: true,
	closeAction: 'close',
	icon:projectGP('/pic/add.gif'),
	layout:'fit',
	items:[
			{
			xtype:'grid',
			name:'preAdd',
			store:'owner.Owner_AddGrid_Store',
			columns: [
		               {xtype:'rownumberer',width:80,align:'center',text:'序号'},
		               {text:'人员姓名',dataIndex:'ownerName', align:'center',menuDisabled:true,flex:.4,editor:{xtype:'textfield',allowBlank:false,blankText:'请填写...'}},
		               {text:'登&nbsp;录&nbsp;名',dataIndex:'loginName', align:'center',menuDisabled:true,flex:.4,editor:{xtype:'textfield',allowBlank:false,blankText:'请填写...'}},
		               {text:'人员工号',dataIndex:'workNum', align:'center',menuDisabled:true,flex:.4,editor:{xtype:'textfield',allowBlank:false,blankText:'请填写...'}},
		           	   {text:'操  作',xtype:'actioncolumn',align:'center',flex:.2,items: [{icon:projectGP('/pic/del.png'),tooltip:'删除',handler:function(g,r,c){var s = g.getStore();if(s.getAt(r).data.colName==''){return}else{s.removeAt(r);s.insert(r,{});}}}]}
		            ],
		    plugins:{
						ptype:'cellediting',
						clicksToEdit:1
					},
			width:'50%',
			height:'100%',
			buttons :[
						{
							name:'winSaveBtn',
							text:'保&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;存',
							width:'100%'
						}
					]
		}
	
	],
	initComppent:function(){
		var me = this;
		me.callParent(arguments);
	}
});