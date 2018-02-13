Ext.define('gwj.view.layout.North',{
		extend:'Ext.Panel',
		alias:'widget.northViewByGWJ',
		id:'northViewByGWJ',
		initComponent:function(){
			var me = this;
			Ext.applyIf(me,{
				region:'north',
				height : 95,
				frame : true,
				collapseMode : 'mini',
				animCollapse : true,
				baseCls : 'x-plain',
				defaultType : 'panel',
				layout : 'fit',
				items:[ {html : '<img src='+projectGP('/pic/title.jpg')+'/>'}],
				dockedItems: [{
				    xtype: 'toolbar',
				    dock: 'bottom',
				    items: [
				        	{html:'<img src='+projectGP('/pic/man.gif')+'/>',frame:false},
				        	'-',
				        	{
				        		xtype : 'label',
								html : '公告：<marquee id="textinfo" width=600 scrollamount=1  direction=left align=middle border=1></marquee>'
				        	},
				        	'->'
//				        	{
//				        		text:'退出系统',
//				        		name:'sysexits',
//				        		icon:projectGP('/pic/logout.png')
//				        	}
				    ]
				}]
			});
			me.callParent(arguments);
		}	
	});
		
		
	