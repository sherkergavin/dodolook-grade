Ext.define('gwj.store.owner.Owner_QueryGrid_List_Store',{
	extend:'Ext.data.Store',
	alias:'widget.owner_QueryGrid_List_Store',
	storeId:'owner_QueryGrid_List_Store',
	fields:[
		{name:'ownerId',type:'string'},
		{name:'ownerName',type:'string'},
		{name:'loginName',type:'string'},
		{name:'workNum',type:'string'},
		{name:'createTime',type:'string'}
	],
	//pageSize:25,
	proxy:{
		type:'ajax',
		url:projectGP('owner/sel'),
		actionMethods:{
			create	:'post',
			read	:'post',
			update	:'post',
			destroy	:'post'
		},
		reader:{
			type:'json',
			root:'data'
			//totalProperty:'totalProperty'
		}
	},
	autoload:false
});