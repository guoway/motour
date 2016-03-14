$(function() {

    $('.i-checks').iCheck({
        checkboxClass: 'icheckbox_square-green',
        radioClass: 'iradio_square-green',
    });
    
    //select2 start
    $('#userId').select2({
    	ajax: {
    		url:contextPath + '/getUserByIdLike',
    		dataType: 'json',
    		delay: 250,
    		cache: true,
    		data: function(params) {
    			return {
    				'userId':params.term,
    				'pageRequest.page': params.page,
    				'pageRequest.rows': 30,
    			};
    		},
    		processResults: function(data, params) {
    			params.page = params.page || 1;
    			
    			return {
    				results: data.rows,
    				pagination: {
    					more: (params.page * 30) < data.total_count,
    				}
    			};
    		},
    		
    	},
    	escapeMarkup: function(markup) {
    		return markup;
    	},
    	minimumInputLength: 2,
    	//templateResult: formatRepo,
    	//templateSelection: formatRepoSelection
    });
    //select2 end
    
    //chosen start
	var config = {
                '.chosen-select'           : {},
                '.chosen-select-deselect'  : {allow_single_deselect:true},
                '.chosen-select-no-single' : {disable_search_threshold:10},
                '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
                '.chosen-select-width'     : {width:"95%"}
	}
	
    for (var selector in config) {
        $(selector).chosen(config[selector]);
    }	
	
	$('#actionForm').validate({
		  onfocusout:function(element){
				this.element(element);
		  },
		  rules: {
		    "id" :{required:true},
		  }		
	});
	
});
