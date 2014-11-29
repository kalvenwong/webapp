(function() {
	var _this = {
		_unbindEvent : function() {
			$('.login_btn').unbind();
		},
		_bindEvent : function() {
			$('.login_btn').bind('click', function() {
				var name = $("#name").val();
				var password = $("#password").val();
				$.ajax({
					type : "post",
					url : "login_addUser",
					dataType : "json",
					data : {
						"sysUser.username" : name,
						"sysUser.password" : password
					},
					success : function(data) {
						$(".logininfo")[0].textContent = "注册成功";
						console.log(data);
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						console.log(errorThrown);
					}
				});
			});
		},
		_initialize : function() {
			_this._unbindEvent();
			_this._bindEvent();
		}
	};
	
	_this._initialize();
})();