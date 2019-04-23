Ext.onReady(function(){	
 

 Ext.define('User', {
           extend: 'Ext.data.Model',
			fields:[ 
			{
                name: 'surname',
                type: 'string'
            }, {
                name: 'name',
                type: 'string'
            }, {
                name: 'patronymic',
                type: 'string' 
            }
			],
			proxy: {
					type: 'rest',
					url : 'http://localhost:8080/rest_appl_glassfish_war_exploded/application/test',
					noCache: true,
					appendId: true, //если true автоматически ставит косую черту после урла
					reader: {
						type: 'json', 
						root : 'persons', 
						totalProperty : 'total'
					},
					extraParams: {
						symbol: ''
					}
			}
					
					
      });	

	  
	   var store = Ext.create('Ext.data.Store', {		   
                    model: 'User',                    
                    autoLoad: true,
					pageSize: 5,
					
        }); 
	
	var formPanel = Ext.create('Ext.Panel', {
                    title: 'Таблица пользователей',					
                    width: 1200,
					height: 400,                    
					//cls: 'field-textfield',                    
                    items: [{               // Results grid specified as a config object with an xtype of 'grid'
						xtype: 'grid',
						id:'myGridID',
						height: 325,						
						bbar: Ext.create('Ext.PagingToolbar', {
							store: store,
							displayInfo: true,
							displayMsg: '{0} - {1} of {2}',
							emptyMsg: "No topics to display"
						}),
						columns: [{header: 'Фамилия',dataIndex: 'surname',flex: 1,align: 'center'},
							      {header: 'Имя',dataIndex: 'name',flex: 1,align: 'center'},
								  {header: 'Отчество',dataIndex: 'patronymic',flex: 1,align: 'center'}],
										// One header just for show. There's no data,
						store: store	                     
						},{
						xtype: 'textfield',
						id:'myTextField',
						name: 'nam',						
						fieldLabel: 'Search',
						labelWidth: 200,     
						
						}
					],
					buttons: [{
						 text: 'Find',
						//handler: function() {
							// действие отправки
							
						//}
						listeners: {
							click: function() {															
								store.proxy.extraParams.symbol= Ext.getCmp('myTextField').getValue();								
								store.load();
																									//User.load(123, {
																									//	success: function(user) {
																									//		console.log(user.getId()); //outputs 123
																									//	}
																									//});
								
							}
						}
					}],
                    renderTo: 'example-text'
                });	
				


	// store.loadPage(1);
	
	
});
 
 
 