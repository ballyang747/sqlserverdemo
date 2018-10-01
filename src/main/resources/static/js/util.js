$(document).ready(function() {
	//	$("body").css("width",document.documentElement.clientWidth-5);  
	//全局初始日期组建


});
/**
 * 新窗口中打开
 * @param url
 * @param tetle
 * @param width
 * @param height
 * @param closeCallback 窗口关闭回调方法
 */
function openNewWindow(url, tetle, width, height,closeCallback) {
	var fulls=",toolbar=no,menubar=no, resizable=no,location=no, status=no";
	if(width<0){
		width=window.screen.availWidth;
	}
	if(height<0){
		height=window.screen.availHeight;
	}
		var iTop = (window.screen.availHeight - height) / 2; // 获得窗口的垂直位置;
		var iLeft = (window.screen.availWidth - width) / 2; // 获得窗口的水平位置;
		fulls='height=' + height + ',width=' + width + ',top='
		+ iTop + ',left=' + iLeft
		+fulls;
	var winObj=window.open(url, tetle,  fulls);
	if(closeCallback!=undefined){
		var loop = setInterval(function() {   
		    if(winObj.closed) {  
		        clearInterval(loop);  
		        closeCallback();
		    }  
		}, 1000);
	}
}
/**
 * 获取get传递参数
 * @param name 参数名称
 * @returns 值
 */
function getUrlParamValue(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return decodeURI(r[2]);
	return null;
}
/**
 * 判断是否移动设备
 * @returns {Boolean}
 */
function isMobile() {
	if (/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i
			.test(navigator.userAgent)) {
		return true;
	} else {
		return false;
	}
}
/**
 * 生产UUID
 * @param len
 * @returns
 */
function uuid(len) {
	var radix = 64;
	var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'
			.split('');
	var uuid = [], i;
	radix = radix || chars.length;

	if (len) {
		// Compact form 
		for (i = 0; i < len; i++)
			uuid[i] = chars[0 | Math.random() * radix];
	} else {
		// rfc4122, version 4 form 
		var r;

		// rfc4122 requires these characters 
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';

		// Fill in random data.  At i==19 set the high bits of clock sequence as 
		// per rfc4122, sec. 4.1.5 
		for (i = 0; i < 36; i++) {
			if (!uuid[i]) {
				r = 0 | Math.random() * 16;
				uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
			}
		}
	}

	return uuid.join('');
}

//对Date的扩展，将 Date 转化为指定格式的String   
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
//例子：   
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.Format = function(fmt) { //author: meizz   
	var o = {
		"M+" : this.getMonth() + 1, //月份   
		"d+" : this.getDate(), //日   
		"h+" : this.getHours(), //小时   
		"m+" : this.getMinutes(), //分   
		"s+" : this.getSeconds(), //秒   
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度   
		"S" : this.getMilliseconds()
	//毫秒   
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
};
/**
 * 给数组添加字符串比较
 * @param e
 * @returns
 */
Array.prototype.in_array=function(e){
	var r=new RegExp(','+e+',');
	return (r.test(','+this.join(this.S)+','));
};
/**
 * 计算日期
 * @param month
 * @param start
 * @returns {Date}
 */
function dataSale(month,start){
	var now;
	var arr;
	if(start!=undefined){
		arr=start.split("-");
	}
	if(arr!=undefined&&arr.length==3){
		var year=arr[0];
		var month=parseInt(arr[1])-1;
		var day=arr[2];
		var now=new Date(year,month,day);
	}else{
		now=new Date();
	}
	month=parseInt(month);
	now.setMonth(now.getMonth()+month);
	now.setDate(now.getDate()-1);
	return now;
}

//监听div大小变化
(function($, h, c) {
	var a = $([]),
	e = $.resize = $.extend($.resize, {}),
	i,
	k = "setTimeout",
	j = "resize",
	d = j + "-special-event",
	b = "delay",
	f = "throttleWindow";
	e[b] = 250;
	e[f] = true;
	$.event.special[j] = {
		setup: function() {
			if (!e[f] && this[k]) {
				return false;
			}
			var l = $(this);
			a = a.add(l);
			$.data(this, d, {
				w: l.width(),
				h: l.height()
			});
			if (a.length === 1) {
				g();
			}
		},
		teardown: function() {
			if (!e[f] && this[k]) {
				return false;
			}
			var l = $(this);
			a = a.not(l);
			l.removeData(d);
			if (!a.length) {
				clearTimeout(i);
			}
		},
		add: function(l) {
			if (!e[f] && this[k]) {
				return false;
			}
			var n;
			function m(s, o, p) {
				var q = $(this),
				r = $.data(this, d);
				r.w = o !== c ? o: q.width();
				r.h = p !== c ? p: q.height();
				n.apply(this, arguments);
			}
			if ($.isFunction(l)) {
				n = l;
				return m;
			} else {
				n = l.handler;
				l.handler = m;
			}
		}
	};
	function g() {
		i = h[k](function() {
			a.each(function() {
				var n = $(this),
				m = n.width(),
				l = n.height(),
				o = $.data(this, d);
				if (m !== o.w || l !== o.h) {
					n.trigger(j, [o.w = m, o.h = l]);
				}
			});
			g();
		},
		e[b]);
	}
})(jQuery, this);

