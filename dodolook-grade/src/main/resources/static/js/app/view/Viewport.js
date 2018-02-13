Ext.define('gwj.view.Viewport',{
		extend:'Ext.container.Viewport',
		alias:'widget.viewportByGWJ',
		id:'viewportByGWJ',
		requires:[
			'gwj.view.layout.Center',
			'gwj.view.layout.North',
			'gwj.view.layout.South',
			'gwj.view.layout.West'
		],
		initComponent:function(){
			var me = this;
			Ext.applyIf(me,{
				layout:'border',
				items:[
					Ext.create('gwj.view.layout.Center'),
					Ext.create('gwj.view.layout.North'),
					Ext.create('gwj.view.layout.South'),
					Ext.create('gwj.view.layout.West')
				]
			});
			me.callParent(arguments);
		}
});