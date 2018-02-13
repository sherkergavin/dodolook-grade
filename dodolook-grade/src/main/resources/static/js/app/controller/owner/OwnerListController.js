Ext.define('gwj.controller.owner.OwnerListController',{
	extend:'Ext.app.Controller',
	alias:'widget.ownerListControllerByGWJ',
	id:'ownerListControllerByGWJ',
	models:[],
	stores:['owner.Owner_QueryGrid_List_Store','owner.Owner_AddGrid_Store'],
	views:['owner.OwnerListView','owner.OwnerAddDialogView','owner.OwnerEditDialogView'],
	refs:[
			{ref:'ownerListViewByGWJ',selector:'ownerListViewByGWJ'},
			{ref:'ownerAddDialogViewByGWJ',selector:'ownerAddDialogViewByGWJ'},
			{ref:'ownerEditDialogViewByGWJ',selector:'ownerEditDialogViewByGWJ'},
			{ref:'winPreAdd',selector:'ownerAddDialogViewByGWJ>grid[name=preAdd]'},
			{ref:'workNum',selector:'ownerEditDialogViewByGWJ>panel>textfield[name=workNum]'},
			{ref:'ownerId',selector:'ownerEditDialogViewByGWJ>panel>hiddenfield[name=ownerId]'},
			{ref:'ownerName',selector:'ownerEditDialogViewByGWJ>panel>textfield[name=ownerName]'},
			{ref:'loginName',selector:'ownerEditDialogViewByGWJ>panel>textfield[name=loginName]'}	
	],
	init:function(){
		var me = this;
		me.control({
					'ownerListViewByGWJ':{render:me.ownerInitFun,itemdblclick: me.itemdbOwnerclick},
					'ownerListViewByGWJ>toolbar>button[action="add"]':{click:me.ownerViewAddBtnFun},
					'ownerListViewByGWJ>toolbar>button[action="edit"]':{click:me.ownerViewEditBtnFun},
					'ownerListViewByGWJ>toolbar>button[action="reset"]':{click:me.ownerViewResetBtnFun},
					'ownerListViewByGWJ>toolbar>button[action="delete"]':{click:me.ownerViewDelBtnFun},
					'ownerAddDialogViewByGWJ>grid[name=preAdd] button[name=winSaveBtn]':{click:me.addDialogOwnerSaveBtnFun}	,
					'ownerEditDialogViewByGWJ button[action="confirm"]':{click:me.editDialogOwnerConfirmBtnFun},
					'ownerEditDialogViewByGWJ button[action="cancel"]':{click:me.editDialogOwnerCancelBtnFun}
				});
	},
	ownerInitFun:function(t, eOpts){
	
		t.store.load();
	},
	iterStoreDataStrategy:function(s){
			s.removeAll();
			for(var i=0; i<17;i++){
				s.insert(i,{});
			}
	},
	ownerViewAddBtnFun:function(t,e,eOpts){
		var me = this;
        var undefine;
        var ownerAddDialogViewByGWJ = Ext.ComponentManager.get('ownerAddDialogViewByGWJ');
        if(ownerAddDialogViewByGWJ == undefine){
            ownerAddDialogViewByGWJ = Ext.create('widget.ownerAddDialogViewByGWJ',{title:'人员(添加)'});
        }
        me.iterStoreDataStrategy(me.getWinPreAdd().getStore());   
        ownerAddDialogViewByGWJ.show();
	},
	addDialogOwnerSaveBtnFun:function(t,e,eOpts){
		var me = this;
		var store = this.getWinPreAdd().getStore();
		var recArr =[];
		store.queryBy(function(r){if(Ext.String.trim(r.data.ownerName)!='' && 
										Ext.String.trim(r.data.loginName)!='' && 
										Ext.String.trim(r.data.workNum)!=''){
										recArr.push({
														createTime:Ext.Date.now(), 
														ownerName:r.data.ownerName,
														loginName:r.data.loginName,
														workNum:r.data.workNum
													});
										}
									});
		if(recArr.length==0){
			me.tipsStrategy('没有东西可以 提交!');
			return;
		}
		me.ajaxDialogOwnerWinStrategy(recArr,'owner/add','sav')
	
	},
	itemdbOwnerclick:function(t, rec, itm, idx, e, eOpts){
		var me = this;
        var undefine;
    	var ownerEditDialogViewByGWJ = Ext.ComponentManager.get('ownerEditDialogViewByGWJ');
        if(ownerEditDialogViewByGWJ == undefine){
            ownerEditDialogViewByGWJ = Ext.create('widget.ownerEditDialogViewByGWJ',{title:'人员(修改)'});
        }
       	me.getOwnerName().setValue(rec.data.ownerName);
       	me.getLoginName().setValue(rec.data.loginName);
        me.getWorkNum().setValue(rec.data.workNum);
        me.getOwnerId().setValue(rec.data.ownerId);
        ownerEditDialogViewByGWJ.show();

	},
	ownerViewEditBtnFun:function(t,e,eOpts){
		var me = this;
        var undefine;
        var recArr = me.selectionStrategy(t);
        if(recArr.length>1){
        	me.tipsStrategy('修改记录 请 逐条的 修改!');
        }else if(recArr.length==1){
        	var ownerEditDialogViewByGWJ = Ext.ComponentManager.get('ownerEditDialogViewByGWJ');
	        if(ownerEditDialogViewByGWJ == undefine){
	            ownerEditDialogViewByGWJ = Ext.create('widget.ownerEditDialogViewByGWJ',{title:'人员(修改)'});
	        }
	        
	        me.getOwnerId().setValue(recArr[0].data.ownerId);
	        me.getWorkNum().setValue(recArr[0].data.workNum);
	       	me.getOwnerName().setValue(recArr[0].data.ownerName);
	        me.getLoginName().setValue(recArr[0].data.loginName);
	        
	        ownerEditDialogViewByGWJ.show();
        }
	},
	ownerViewResetBtnFun:function(t,e,eOpts){
		this.resetloadStrategy(t);
	},
	resetloadStrategy:function(t){
		t.up('grid').store.load();
	},
	ajaxDialogOwnerWinStrategy:function(r,u,f){
		var me = this;
		Ext.Ajax.request({
			 url:projectGP(u),
			 params: {'data':Ext.encode(r)},
			 success: function(response){
			 	var obj = Ext.decode(response.responseText);
			     if(obj.success){
					if(f=='sav'){
						me.getOwnerAddDialogViewByGWJ().close();
					}else if(f=='upd'){
						me.cleanDataStrategy();
						me.getOwnerEditDialogViewByGWJ().close();
					}
					me.getOwnerListViewByGWJ().getStore().load();
					
			     }  
			 }
		});
	
	},
	selectionStrategy:function(t){
		var recArr = t.up('grid').getSelectionModel().getSelection(); 
		return recArr;
	},
	cleanDataStrategy:function(){
		var me = this;
		me.getOwnerId().setValue('');
		me.getOwnerName().setValue('');
		me.getWorkNum().setValue('');
		me.getLoginName().setValue('');
	},
	editDialogOwnerCancelBtnFun:function(t,e,eOpts){
		var me = this;
		me.cleanDataStrategy();
		me.getOwnerEditDialogViewByGWJ().close();
	},
	editDialogOwnerConfirmBtnFun:function(t,e,eOpts){
		var me = this;
		var workNum = Ext.String.trim(me.getWorkNum().getValue());
		var ownerName = Ext.String.trim(me.getOwnerName().getValue());
		var loginName = Ext.String.trim(me.getLoginName().getValue());
		
		var recArr = me.getOwnerListViewByGWJ().getSelectionModel().getSelection(); 
		var rec = recArr[0].data;
	
		if(rec.ownerName != ownerName || rec.workNum != workNum || rec.loginName != loginName){
			var r = {
						ownerId:me.getOwnerId().getValue(),
						workNum:workNum,
						ownerName:ownerName,
						loginName:loginName
					}
			
			me.ajaxDialogOwnerWinStrategy(r,'owner/upd','upd')
		}else{
			me.cleanDataStrategy();
			me.getOwnerEditDialogViewByGWJ().close();
		}
	},
	tipsStrategy:function(msg){
		Ext.Msg.show({title:'提 示',msg:msg,buttons: Ext.Msg.OK,icon: Ext.Msg.WARNING});
	},
	ownerViewDelBtnFun:function(t,e,eOpts){
		var me = this;
		var recArr = me.selectionStrategy(t);
		if(recArr.length>0){
			var nameStr = "";
			var ownIdArr = [];
			Ext.each(recArr,function(item){
				nameStr +='<br/><span style="color: red;float:left;font-size:14px;">'+item.data.ownerName+'('+item.data.workNum +')</span><br/>';
				ownIdArr.push(item.data.ownerId);
			});
			Ext.Msg.show({
				    title: '用户(删除)',
				    msg: '确定要删除以下人员吗?<br/> '+ nameStr,
				    width: 300,
				    buttons: Ext.Msg.YESNO,
				    icon: Ext.Msg.WARNING,
				    fn: function(btn){
				    	 if(btn=='yes'){
				    	 	Ext.Ajax.request({
					            url: projectGP('owner/del'),
					            params: {ownIds:ownIdArr.join(',')},
					            success: function(response){
					            		me.resetloadStrategy(t);
					            }
				    		});
				    	 }
				    }
				});	
		}
	}
});