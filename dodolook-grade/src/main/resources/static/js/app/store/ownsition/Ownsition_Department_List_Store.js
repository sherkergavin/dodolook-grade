Ext.define('gwj.store.ownsition.Ownsition_Department_List_Store',{
		extend :'Ext.data.Store',
		alias:'widget.ownsition_Department_List_Store',
		storeId:'ownsition_Department_List_Store',
		fields: [
			{name:'departId',type:'string'}, 
			{name:'departName',type:'string'}
			],
		proxy:{
			type:'ajax',
			url:projectGP('/stand/seldepart'),
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
	    autoLoad : true
});