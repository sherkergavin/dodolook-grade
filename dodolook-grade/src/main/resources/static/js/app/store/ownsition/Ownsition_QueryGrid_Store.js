Ext.define('gwj.store.ownsition.Ownsition_QueryGrid_Store',{
		extend:'Ext.data.Store',
		alias:'widget.ownsition_QueryGrid_Store',
		storeId:'ownsition_QueryGrid_Store',
		groupField:'groupId',
		fields:[	
			{name:'logupId',type:'string'},
			{name:'loginId',type:'string'},
			{name:'loginName',type:'string'},
			{name:'ownerName',type:'string'},
			{name:'workNum',type:'string'},
			{name:'groupId',type:'string'},
			{name:'groupName',type:'string'},
			{name:'departId',type:'string'},
			{name:'departName',type:'string'},
			{name:'postId',type:'string'},
			{name:'postName',type:'string'}
		],
		proxy:{
			type:'ajax',
			url:projectGP('/ownsition/usergroup'),
			actionMethods: {
                create : 'POST',
                read   : 'POST',
                update : 'POST',
                destroy: 'POST'
            },
			reader:{
					type:'json',
					root:'data'
			}
		},
		autoLoad:true
});
