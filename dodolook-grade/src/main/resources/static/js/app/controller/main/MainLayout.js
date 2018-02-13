Ext.define('gwj.controller.main.MainLayout',{
		alias:'widget.mainLayoutByGWJ',
		extend:'Ext.app.Controller',
		config:{
				point:'.',
				view:'View',
				controller:'Controller'
		},
		refs:[
				{ref:'westViewByGWJ',selector:'westViewByGWJ'},
				{ref:'centerViewByGWJ',selector:'centerViewByGWJ'}
				
			],
		views:[
				'gwj.view.layout.North',
        		'gwj.view.layout.South',
        		'gwj.view.layout.West',
        		'gwj.view.layout.Center'
			],
			init:function(){
				var me = this;
				me.control({
					'westViewByGWJ':{afterrender:me.afterRenderFun},
					'centerViewByGWJ':{destroy:me.destroyFun,close:me.closeFun},
					'northViewByGWJ>toolbar>button[name = sysexits]':{click:me.exitsClickFun}
				});
			},
			
			closeFun:function( p, eOpts ){
				
				console.log(p);
			},
			destroyFun:function(t,eOpts){
				console.log(t);
			},
			tipsStrategyFun:function(msg){
		        Ext.Msg.show({title:'提 示',msg:msg,buttons: Ext.Msg.OK,icon: Ext.Msg.WARNING});
	        },
			exitsClickFun:function(t,eOpts){
				location.href = projectGP('/lg/logout');	
			},

			afterRenderFun:function(t,eOpts){
				var me = this;
				Ext.Ajax.request({
					method :'post',
				    url: projectGP('/menu/sel'),
				    success: function(response){
				    	var json = Ext.JSON.decode(response.responseText);
				    	if(json.success){
					    	Ext.each(json.data, function(item) {  
						    	var treePanel =  Ext.create('Ext.tree.Panel', {  
		                           	rootVisible : false,
		                           	title:item.text,
		                            store : Ext.create('Ext.data.TreeStore', {  
		                                        root : {  
		                                            text:item.text,
													id:item.id,
													leaf:item.leaf,
													expanded: item.expanded,
		                                            children : item.children  
		                                        }  
		                                    }),
		                            listeners : {  
		                                'itemclick' : function(view, record, item,index, e) {  
		                                    var hrefTarget = record.get('hrefTarget'); 
		                                    var hrefTargetArr = hrefTarget.split('.');
		                                    var hrefTargetStr = hrefTargetArr[hrefTargetArr.length-1];
		                                   	var hrefTargetInt = hrefTargetStr.indexOf(me.config.view);

		                                    if(hrefTargetInt != -1){
		                                   		gwj.getApplication().getController(hrefTargetArr[hrefTargetArr.length-2]+me.config.point+hrefTargetStr.substring(0,hrefTargetInt)+me.config.controller);             
		                                    }
		                                    if (record.get('leaf')) { 
		                                    	me.getCenterViewByGWJ().loadPage(hrefTarget,record.get('id'),record.get('text'));
		                                    }  
		                                },  
		                                scope : this  
		                           }  
		                        });  
		                        t.add(treePanel);
						    });
				    	}
				    }
				});
			}
		});