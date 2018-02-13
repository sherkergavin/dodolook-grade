Ext.define('gwj.view.ownsition.OwnsitionGroupView',{
	extend:'Ext.panel.Panel',
	alias:'widget.ownsitionGroupViewByGWJ',
	id:'ownsitionGroupViewByGWJ',
	config: {
    	groupMap: {},
    	groupNameMap: {}
	},
	initComponent:function(){
			var me = this;
			Ext.apply(this,{
			title:'用户职位',
			autoScroll : true,
			frame:true,
			layout:{
	    				type: 'hbox',
	    				pack: 'start',
	    				align: 'stretch'
					},
			items:[
					{
						frame:false,
						width:'70%',
						baseCls:'x-plain',
						layout:{
	    					type: 'vbox',
	    					pack: 'start',
	    					align: 'stretch'
						},
						items:[
								{
									xtype:'grid',
									frame:false,
									name:'addOwnsitionGrid',
									autoScroll : true,
									viewConfig: {forceFit:true},
									store: 'ownsition.Ownsition_AddGrid_Store',
	    							width:'100%',
	    							flex: 4,
	    							columns: [
								           {xtype: 'rownumberer',width:50,align:'center',text:'序号'},
							               {text: '登录名', dataIndex:'loginName', align:'center',menuDisabled: true},
							               {text: '姓名', dataIndex:'ownerName',align:'center', menuDisabled: true},
							               {text: '部门', dataIndex:'departName',align:'center', menuDisabled: true},
							               {text: '职位', dataIndex:'postName',align:'center', menuDisabled: true}  
									           ],
									dockedItems:[
												  {
													xtype:'toolbar',
													dock: 'top',
													autoScroll : true,
													items:[
														{
														 xtype: 'combo',
														 width:240,
							                             fieldLabel: '',
							                             emptyText:'请选择     部   门',
							                             name: 'departmentCombo',
							                             store: 'ownsition.Ownsition_Department_List_Store',
							                             queryMode: 'local',
							                             displayField: 'departName',
							                             valueField: 'departId',
							                             editable: false
							    						},
							    						'-',
							    						{
							    						 xtype: 'combo',
							    						 width:240,
							                             fieldLabel: '',
							                             emptyText:'请选择     职    位',
							                             name: 'positionCombo',
							                             store: 'ownsition.Ownsition_Position_List_Store',
							                             queryMode: 'local',
							                             displayField: 'postName',
							                             valueField: 'postId',
							                             editable: false
							    						},
							    						'-',
							    						{
							    							xtype:'button',
															name:'addDepartmentBtn',
															width:100,
															icon : projectGP('/pic/department.gif'),
															text:'添加  部门'
							    						},
							    						'-',
							    						{
							    							xtype:'button',
															name:'addPositionBtn',
															width:100,
															icon : projectGP('/pic/position.png'),
															text:'添加  职位'
							    						},
														'->',
														{
															xtype:'button',
															name:'ownsitionSaveBtn',
															width:100,
															icon : projectGP('/pic/save.png'),
															text:'保   存'
														}
													]
												}
											]
											           
								},
								{
									xtype:'panel',
									frame:false,
									baseCls:'x-plain',
									height:20
								},
								{
									xtype:'grid',
									frame:false,
									id:'queryOwnsitionGrid',
									name:'queryOwnsitionGrid',
									autoScroll : true,
									viewConfig: {forceFit:true},
									store: 'ownsition.Ownsition_QueryGrid_Store',
	    							width:'100%',
	    							flex: 6,
	    							columns: [
									               {xtype: 'rownumberer',width:80,align:'center',text:'序号'},
									               {text: '登&nbsp;录&nbsp;名',width:160, dataIndex:'loginName', align:'center',menuDisabled: true},
									               {text: '姓&nbsp;&nbsp;&nbsp;&nbsp;名',width:160, dataIndex:'ownerName',align:'center', menuDisabled: true},
									               {text: '工&nbsp;&nbsp;&nbsp;&nbsp;号',width:160, dataIndex:'workNum',align:'center', menuDisabled: true},
									               {text: '部 门 职 位',width:160, dataIndex:'groupName',align:'center', menuDisabled: true},
									               {width:160,align:'center', menuDisabled: true ,renderer:function(val, m, rec, rIdx,cIdx,s,v,r){
																															var str ='';
																															str += '<a target="_self" onclick="Ext.MessageBox.show({title:\'提示\',msg:\'确认要删除&nbsp;&nbsp;<span style=color:red;font-size:14px;>'+rec.data.groupName+'&nbsp;&nbsp;'+ rec.data.ownerName+'('+rec.data.workNum +')</span>' +'&nbsp;&nbsp;吗?\', buttons: Ext.Msg.YESNO,fn:function(btn){var me = this; if(btn==\'yes\'){ Ext.Ajax.request({url:projectGP(\'\/ownsition\/delsingle\'),params:{logupId:'+rec.data.logupId+',groupId:'+rec.data.groupId+',loginId:'+rec.data.loginId+'},success:function(response){  var grid = Ext.getCmp(\'queryOwnsitionGrid\');var store = grid.getStore();store.reload();}});}}})"><span style="color:#009;cursor:pointer;text-decoration:underline;">删&nbsp;&nbsp;除</span></a>';
																															return str;
																															}}
									           ],                  
									features:[
								               Ext.create('Ext.grid.feature.Grouping',{
								                           groupByText:'分组',
								                           groupHeaderTpl:['<div style="line-height: 20px; vertical-align: middle; ">{rows:this.renderFun} <input  style="display: inline-block;float: right; margin-right: 10px" id={name}  type="button" name="delGroup"  value="删除用户组"/></div>',
								                           	  {
								                           	  	renderFun:function(rows){
								                           	  		me.groupNameMap[rows[0].data.groupId] = rows[0].data.groupName;
								                           	  		return rows[0].data.groupName;
								                           	  	}
								                           	  }
								               				],
								                           showGroupText:'展示分组',
								                           startCollapsed: false
	                            				})
			           						],
			           				listeners:{
           									 'groupclick':function( view, node, group, e, eOpts ){
           									 
           									 	  if (e.getTarget().type === 'button'){
               											view.features[0].expand(group,true);
           											}
           										  if (e.getTarget().name === 'delGroup'){
	           									 	  Ext.MessageBox.show({
								                           title:'提示',
								                           msg:'确认要删除<span style="color: red;float:left;font-size:14px;">《'+me.groupNameMap[e.getTarget().id]+'》</span>吗?',
								                           buttons: Ext.Msg.YESNO,
								                           fn: function(btn){
								                               if(btn=='yes'){
								                                   Ext.Ajax.request({
								                                       url: projectGP('/ownsition/delgroup'),
								                                       params: {
								                                           groupId: e.getTarget().id
								                                       },
								                                       success: function(response){
								                                           var itemArr = me.items.items;
								                                           var item2Arr = itemArr[0].items.items;
								                                           var store = item2Arr[2].getStore();
								                                           store.reload();
								                                       }
								                                   });
								                               }
								                           },
								                           icon: Ext.MessageBox.WARNING
							                       });
           									 	}  
           									 }
		           						}
								}
						]
					},
					{
						frame:true,
						width:'1%',
						baseCls:'x-plain'
					},
					{
						xtype:'grid',
						frame:false,
						width:'28.8%',
						name:'selOwnerGrid',
						autoScroll : true,
						viewConfig: {forceFit:true},
						store: 'ownsition.Owner_QueryGrid_SampleList_Store',
						selModel:Ext.create('Ext.selection.CheckboxModel'), 
						disableSelection: false,//可以选择行    
						flex: 10,
						columns: [
						            {text: '登录名', dataIndex:'loginName', align:'center',menuDisabled: true,flex:.3},
						            {text: '姓&nbsp;名', dataIndex:'ownerName',align:'center', menuDisabled: true,flex:.3},
						            {text: '工&nbsp;号', dataIndex:'workNum',align:'center', menuDisabled: true,flex:.3}
						         ]
					}
			]
			});
			
			var delSingleOwnerFun = function(rec){

	
	console.log(rec.data);
	
	
//Ext.MessageBox.confirm('提示','确认要审核此记录吗?',function(_b){
//													if(_b=='yes'){
//													
//														Ext.Ajax.request({
//																url:basePath+"/myProduct/operate/update_auditingProduct.html", 
//																params:{pdId:pdId,Auditing:Auditing},
//																callback:function(x,y,response){
//																var m =Ext.decode(response.responseText);
//																if(m.success){
//																	FreeDomProductStore.reload();
//																}else{
//																	Ext.MessageBox.alert('提示',m.error);
//																	return;
//																		}
//																	}
//																});	
//													}});


}

			
			
			me.callParent(arguments);
	}
});