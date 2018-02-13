Ext.define('gwj.view.owner.OwnerEditDialogView',{
	extend:'Ext.window.Window',
	alias:'widget.ownerEditDialogViewByGWJ',
	id:'ownerEditDialogViewByGWJ',
	width:400,
    height:170,
   	resizable: false,
   	plain:true,
   	modal: true,
	closable: true,
	closeAction: 'close',
	icon:projectGP('/pic/edit.gif'),
	layout:'fit',
	items:[
			{
				xtype:'panel',
				layout:{type: 'vbox', align: 'center'},
				baseCls:'x-plain',
                margin:'10 0 0 0',
                items:[
	                    {xtype: 'hiddenfield', name: 'ownerId'},
	                    {
	                        xtype:'textfield',
	                        name: 'loginName',
	                        width:'80%',
	                        labelWidth:60,
	                        labelAlign : 'left',
	                        fieldLabel: '登录名',
	                        allowBlank: false
	
	                    },
	                    {
	                        xtype:'textfield',
	                        name: 'ownerName',
	                        width:'80%',
	                        labelWidth:60,
	                        labelAlign : 'left',
	                        fieldLabel: '姓&nbsp;&nbsp;&nbsp;名',
	                        allowBlank: false
	
	                    },
	                    {
	                        xtype:'textfield',
	                        name: 'workNum',
	                        width:'80%',
	                        labelWidth:60,
	                        labelAlign : 'left',
	                        fieldLabel: '工&nbsp;&nbsp;&nbsp;号',
	                        allowBlank: false
	
	                    }
                   ]
			}
	],
	buttons:[
				{
					text:'确&nbsp;&nbsp;&nbsp;定',
					icon:projectGP('/pic/save.png'),
					action:'confirm'
				},
				{
					text:'取&nbsp;&nbsp;&nbsp;消',
					icon:projectGP('/pic/cancel.png'),
					action:'cancel'
				}
			],
	initComppent:function(){
		var me = this;
		me.callParent(arguments);
	}
});