Ext.Loader.setConfig({enabled: true});

Ext.application({
	name:'gwj',
	appFolder:projectGP('/js/app'),
	autoCreateViewport: true,
	controllers:['main.MainLayout']	
});