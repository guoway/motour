/**
 * zip_select.js用來智慧選擇台灣郵遞區號。
 * 
 * Developer於郵遞區號的input tag中加入一個css class「zipselect」，如下：
 * <form:input type="text" class="form-control zipselect" placeholder="郵遞區號" path="invZip"/> 
 * 加入後，User於input box中輸入關鍵字，即可自動帶出相對應的郵遞區號。
 * 
 * Developer可呼叫本js中的registerOnZipSelectedCallback(callback)，進行callback的實作。
 * 當User選定郵遞區號後，本js即會呼叫該callback並傳入一zip object參數。
 * 
 * @dependencies
 * typeahead.bundle.js
 * jquery.js
 * zip_select.css
 */
var onZipSelectedCallback;

$(function(){
	var zips = new Bloodhound({	
		datumTokenizer: Bloodhound.tokenizers.obj.whitespace('tokenStr'),
		queryTokenizer: Bloodhound.tokenizers.whitespace,
		identify: function(obj) {
			return obj.zip;
		},
		prefetch: {
			url:'getZipCodeList',
			cache:false,
		}
	});
	
	console.log(zips.get(103));
	
	$('.zipselect').bind('typeahead:select', function(e, o) {
		if(onZipSelectedCallback) {
			onZipSelectedCallback(o);
		}
	});
	
	$('.zipselect').typeahead({
		hint:true,
		hightlight:true,
		minLength:1,	
	}, {
		name : 'zips',
		display : 'zip',
		source : zips,		
		templates: {
			suggestion: function(obj) {				
				return "<p><strong>" + obj.zip + " " + obj.value + "</strong></p>";
			}
		}
	});	
});

function registerOnZipSelectedCallback(callback) {
	onZipSelectedCallback = callback;
}