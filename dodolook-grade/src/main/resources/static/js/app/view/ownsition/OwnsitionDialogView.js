Ext.define('gwj.view.ownsition.OwnsitionDialogView',{
	extend:'Ext.window.Window',
	alias:'widget.ownsitionDialogViewByGWJ',
	id:'ownsitionDialogViewByGWJ',
	width:550,
	height:450,
	plain:true,
	resizable: false,
	modal: true,
	closable: true,
	layout:{
	    	type: 'hbox',
	    	pack: 'start',
	    	align: 'stretch'
			},
	items:[
		{
			xtype:'grid',
			name:'hasAdded',
			autoScroll:true,
			store:'ownsition.DepartPos_ListGrid_Store',
			columns: [
		               {xtype: 'rownumberer',width:50,align:'center',text:'序号'},
		               {text:'已添加列表',width:180, dataIndex:'colName', align:'center',menuDisabled: true,flex:1}
		           ],
			width:'49%',
			height:'100%'
		},
		{
			xtype:'panel',
			baseCls:'x-plain',
			width:'1%',
			height:'100%'
		},
		{
			xtype:'grid',
			name:'preAdd',
			store:'ownsition.DepartPos_AddGrid_Store',
			columns: [
		               {xtype: 'rownumberer',width:50,align:'center',text:'序号'},
		               {text:'准备添加列表',dataIndex:'colName', align:'center',menuDisabled:true,flex:.8,editor:{xtype:'textfield',allowBlank:false,blankText:'请填写...'}},
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
	
	initComponent:function(){
		var me = this;
		
		me.callParent(arguments);
	}
});

