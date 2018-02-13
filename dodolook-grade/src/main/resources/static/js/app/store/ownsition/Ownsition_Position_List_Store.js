Ext.define('gwj.store.ownsition.Ownsition_Position_List_Store',{
		extend:'Ext.data.Store',
		alias:'widget.ownsition_Position_List_Store',
		storeId: 'ownsition_Position_List_Store',
		fields: [
			{name:'postId',type:'string'}, 
			{name:'postName',type:'string'}
			],
	    proxy:{
			type:'ajax',
			url:projectGP('/stand/selpost'),
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