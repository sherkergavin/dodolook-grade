Ext.define('gwj.controller.ownsition.OwnsitionGroupController',{
	extend:'Ext.app.Controller',
	alias:'widget.ownsitionGroupControllerByGWJ',
	id:'ownsitionGroupControllerByGWJ',
	models:[],
	stores:[
			'ownsition.Owner_QueryGrid_SampleList_Store','ownsition.Ownsition_AddGrid_Store',
			'ownsition.Ownsition_QueryGrid_Store','ownsition.Ownsition_Department_List_Store',
			'ownsition.Ownsition_Position_List_Store','ownsition.DepartPos_AddGrid_Store',
			'ownsition.DepartPos_ListGrid_Store'
			
		  ],
	views:['ownsition.OwnsitionGroupView','ownsition.OwnsitionDialogView'],
	refs:[
			{ref:'selOwnerGrid',selector:'ownsitionGroupViewByGWJ>grid[name="selOwnerGrid"]'},
			{ref:'addOwnsitionGrid',selector:'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]'},
			{ref:'queryOwnsitionGrid',selector:'ownsitionGroupViewByGWJ>panel>grid[name="queryOwnsitionGrid"]'},
			{ref:'departmentCombo',selector:'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>combo[name="departmentCombo"]'},
			{ref:'positionCombo',selector:'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>combo[name="positionCombo"]'},
			{ref:'ownsitionPreAdd',selector:'ownsitionDialogViewByGWJ>grid[name="preAdd"]'},
			{ref:'ownsitionHasAdded',selector:'ownsitionDialogViewByGWJ>grid[name="hasAdded"]'}
			
	],
	init:function(){
		var me = this;
		this.control({
			'ownsitionGroupViewByGWJ':{close:me.ownsitionGroupCloseFun},
			'ownsitionGroupViewByGWJ>grid[name="selOwnerGrid"]':{render:me.selOwnerGridInitFun},
			'ownsitionGroupViewByGWJ>grid[name=selOwnerGrid]':{select:me.selectOwnerGridFun,deselect:me.deselectOwnerGridFun},
			'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>combo[name="departmentCombo"]':{select:me.selDepartmentComboFun},
			'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>combo[name="positionCombo"]':{select:me.selPositionComboFun},
			'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>button[name="addDepartmentBtn"]':{click:me.addDepartmentBtnFun},
			'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>button[name="addPositionBtn"]':{click:me.addPositionBtnFun},
			'ownsitionGroupViewByGWJ>panel>grid[name="addOwnsitionGrid"]>toolbar>button[name="ownsitionSaveBtn"]':{click:me.addOwnsitionSaveBtnFun},
			'ownsitionDialogViewByGWJ>grid[name="preAdd"] button[name="winSaveBtn"]':{click:me.ownsitionWinSaveBtnFun}
		});
	},
	selOwnerGridInitFun:function(t, eOpts){
		var me = this;
		var qogs = me.getQueryOwnsitionGrid().getStore();
		qogs.load();
		t.store.load();
	},
	deselectOwnerGridStrategy:function(r){
		var me = this;
		me.getSelOwnerGrid().getSelectionModel().deselect(r);
	},
	setComboNullStrategy:function(){
		var me = this;
		me.getPositionCombo().setValue(null);
		me.getDepartmentCombo().setValue(null);
	},
	addStoreUrlStrategy:function(s,u){
		s.removeAll();
		s.setProxy({
				type:'ajax',
				url:projectGP(u),
				actionMethods:{
						   create : 'POST',
			               read   : 'POST',
			               update : 'POST',
			               destroy: 'POST'
				},
				reader:{
					type:'json',
					root:'data'
				}
		});
		s.load();
	},
	iterOwnerGridStrategy:function(){
		var me = this;
		var recArr = me.getSelOwnerGrid().getSelectionModel().getSelection();
		Ext.Array.each(recArr,function(item){
			me.deselectOwnerGridStrategy(item);
		});
	},
	queryOwnsitionGridStrategy:function(q){
	 	q.getStore().reload();
	},
	chageDataStrategy:function(k,v,s,f){
		s.each(function(item,idx){
			if(f=='depart'){
				s.getAt(idx).set('departId',k); 
				s.getAt(idx).set('departName',v); 
			}else if(f=='post'){
				s.getAt(idx).set('postId',k); 
				s.getAt(idx).set('postName',v); 
			}
			s.commitChanges();
		});
	},
	iterStoreDataStrategy:function(s){
			s.removeAll();
			for(var i=0; i<17;i++){
				s.insert(i,{});
			}
	},
	ownsitionGroupCloseFun:function(t, eOpts){
		var me = this;
		var aogs = me.getAddOwnsitionGrid().getStore();
		var sogs = me.getSelOwnerGrid().getStore();
		var qogs = me.getQueryOwnsitionGrid().getStore();
		aogs.removeAll();
		sogs.removeAll();
		qogs.removeAll();
	},
	ajaxOwnsitionDataStrategy:function(s,aogs,d,p,q){
		var me = this; 		
		Ext.Ajax.request({
			 url:projectGP('/ownsition/add'),
			 params: {data:Ext.encode({'departId':d,'postId':p,'list':s})},
			 success: function(response){
			 	var obj = Ext.decode(response.responseText);
			     if(obj.success){
					aogs.removeAll();
			     	me.queryOwnsitionGridStrategy(q);
					me.iterOwnerGridStrategy();
					me.setComboNullStrategy();
			     }  
			 }
		});
	},
	selectDataStrategy:function(r){
		var me = this;
		var aogStore = me.getAddOwnsitionGrid().getStore();
		var positValue = me.getPositionCombo().getValue();
		var departValue = me.getDepartmentCombo().getValue();
		var positRawValue = me.getPositionCombo().getRawValue(); 
		var departRawValue = me.getDepartmentCombo().getRawValue(); 
		var recArr = me.getSelOwnerGrid().getSelectionModel().getSelection();
		if(positValue == null || departValue == null){
			me.tipsStrategy('请选择 部门  和  职位  必选!');
			me.deselectOwnerGridStrategy(r);
			return;
		}
		aogStore.removeAll();
		Ext.Array.each(recArr,function(item){
				var i = aogStore.getCount();
				aogStore.insert(i,{'ownerId':item.data.ownerId,'loginId':item.data.loginId,'loginName':item.data.loginName,'ownerName':item.data.ownerName,'departName':departRawValue,'departId':departValue,'postName':positRawValue,'postId':positValue});
		});
	},
	tipsStrategy:function(msg){
		Ext.Msg.show({title:'提 示',msg:msg,buttons: Ext.Msg.OK,icon: Ext.Msg.WARNING});
	},
	submitDialogWinStrategy:function(r,u,s,c){
		var me = this;
		Ext.Ajax.request({
			 url:projectGP(u),
			 params: {'data':Ext.encode(r)},
			 success: function(response){
			 	var obj = Ext.decode(response.responseText);		     
			 	if(obj.success){
					me.iterStoreDataStrategy(s);
					var store = me.getOwnsitionHasAdded().getStore();
					store.reload();
					if(c=='department'){
						me.getDepartmentCombo().getStore().reload();
					}else{
						me.getPositionCombo().getStore().reload();
					}
			     }  
			 }
		});
	},
	selPositionComboFun:function(t, r, eOpts){
		var me = this;
		me.chageDataStrategy(r[0].data.postId,r[0].data.postName,me.getAddOwnsitionGrid().getStore(),'post');
	},
	selDepartmentComboFun:function(t, r, eOpts){
		var me = this;
		me.chageDataStrategy(r[0].data.departId,r[0].data.departName,me.getAddOwnsitionGrid().getStore(),'depart');
	},
	selectOwnerGridFun:function(t,r,idx,eOpts){
		var me = this;
		me.selectDataStrategy(r);
	},
	deselectOwnerGridFun:function(t,r,idx,eOpts){
		var me = this;
		me.selectDataStrategy(r);	
	},
	addOwnsitionSaveBtnFun:function(t, e, eOpts){
		var me = this;
		var positValue = me.getPositionCombo().getValue();
		var departValue = me.getDepartmentCombo().getValue();
		if(positValue == null|| departValue==null){
			this.tipsStrategy('请选择 部门  和  职位  必选!');
			return;
		}
		var aogStore = me.getAddOwnsitionGrid().getStore();
		if(aogStore.getCount()==0){
			this.tipsStrategy('请选择 左侧的人员  必选!');
			return
		}
		var qogStore = me.getQueryOwnsitionGrid().getStore();
		var opinData = [];
		var submitData = [];
		aogStore.each(function(item,idx){				 
			opinData.push({loginId:item.data.loginId,departId:item.data.departId,postId:item.data.postId});
		});
		for(var i=0;i<opinData.length;i++){
			var exist = false;
			qogStore.findBy(function(item){
				if(opinData[i].loginId == item.data.loginId && opinData[i].departId == item.data.departId && opinData[i].postId == item.data.postId){
					exist = true;
			 		return
				}
			});
			if(!exist){
				submitData.push(opinData[i].loginId);
			}
		}
		if(submitData.length<=0){
			me.tipsStrategy('重复数据 不能提交');
			return
		}	
		me.ajaxOwnsitionDataStrategy(submitData,aogStore,departValue,positValue,me.getQueryOwnsitionGrid());
	},
	addDepartmentBtnFun:function(t, e, eOpts){
		var me = this;
        var undefine;
    	var ownsitionDialogViewByGWJ = Ext.ComponentManager.get('ownsitionDialogViewByGWJ');
        if(ownsitionDialogViewByGWJ == undefine){
            ownsitionDialogViewByGWJ = Ext.create('widget.ownsitionDialogViewByGWJ',{title:'部门(添加)',config:{category:'department'},icon : projectGP('/pic/department.gif')});
        }
        me.addStoreUrlStrategy(me.getOwnsitionHasAdded().getStore(),'/stand/seldepcom');
        me.iterStoreDataStrategy(me.getOwnsitionPreAdd().getStore());
        ownsitionDialogViewByGWJ.show();

	},
	addPositionBtnFun:function(t, e, eOpts){
		var me = this;
        var undefine;
    	var ownsitionDialogViewByGWJ = Ext.ComponentManager.get('ownsitionDialogViewByGWJ');
        if(ownsitionDialogViewByGWJ == undefine){
            ownsitionDialogViewByGWJ = Ext.create('widget.ownsitionDialogViewByGWJ',{title:'职位(添加)',config:{category:'position'},icon : projectGP('/pic/position.png')});
        }
        me.addStoreUrlStrategy(me.getOwnsitionHasAdded().getStore(),'/stand/selposcom');
        me.iterStoreDataStrategy(me.getOwnsitionPreAdd().getStore());
        ownsitionDialogViewByGWJ.show();
	},
	ownsitionWinSaveBtnFun:function(t, e, eOpts){
		var me = this;
		var store = me.getOwnsitionPreAdd().getStore();
		var recArr =[];
		var category = t.up('window').config['category'];
		store.queryBy(function(r){if(Ext.String.trim(r.data.colName)!=''){recArr.push({colName:r.data.colName,createTime:Ext.Date.now()});}});
		
		var url = category=='department'?'/stand/adddepart':'/stand/addposit';
		if(recArr.length==0){
			me.tipsStrategy('没有东西可以 提交!');
			return;
		}
		me.submitDialogWinStrategy(recArr,url,store,category);
	}
	
	
});