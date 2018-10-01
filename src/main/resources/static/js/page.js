$(function() {
		search(1);
});
function orderBy(form,order){
	$(form).find("input[name='order']").val(order);
	search(1);
}


/**
 * 分页组件封装
 * @param url
 * @param page
 * @param data
 * @param callBack
 */
function initPage(url,page,data,callBack){
	data.push({name: "page", value: page});
	$.ajax({
        type: "POST",
        url: url,
        data: data,
        dataType: "json",
        success: function (result) {
            if (result.code == 0) {
            	$('.page_div').pagination({
        			jump : false,
        			coping : true,
        			isHide : false,
        			totalData : result["data"]["total"],
        			showData : result["data"]["pageSize"],
        			count : 6,
        			mode : 'fixed',
        			prevContent : '<',
        	    nextContent: '>',
        			homePage : '<<',
        	    endPage: '>>',
        			callback : function(api) {
        				for(var key in data){
        					if(data[key].name=="page"){
        						data[key].value=api.getCurrent();
        					}
        				}
        				$.ajax({
        			        type: "POST",
        			        url: url,
        			        data: data,
        			        dataType: "json",
        			        success: function (result) {
        			            callBack(result,api.getCurrent());
        			        },
    	        		    error: function (message) {
    	        		    	var result={};
    	        		    	result.code=1;
    	        		    	result.message=message.statusText+"("
    		    				+message.status+")";
    	        		    	callBack(result,api.getCurrent());
    	        		    }
        				});
        			}
        		});
		    	callBack(result,page);
            }
        },
        error: function (message) {
        	var result={};
	    	result.code=1;
	    	result.message=message.statusText+"("
			+message.status+")";
	    	callBack(result,page);
        }
    });
}
