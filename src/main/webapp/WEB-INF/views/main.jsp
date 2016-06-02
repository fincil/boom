<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" session="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Boom</title>
<link rel="stylesheet" href="/resources/custom/css/normalize.css">
<link rel="stylesheet" href="/resources/assets/lib/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/resources/assets/lib/bootflat/css/bootflat.min.css"> <!-- 부트스트랩 테마 Bootflat CSS -->
<link rel="stylesheet" href="/resources/custom/css/custom.css">
<script data-main="/resources/js/main" src="/resources/lib/jquery/jquery-2.1.0.min.js"></script>
<script data-main="/resources/js/main" src="/resources/lib/bootstrap/js/bootstrap.min.js"></script>
<script data-main="/resources/js/main" src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script data-main="/resources/js/main" src="/resources/lib/pjax/jquery.pjax.js"></script>
<script data-main="/resources/js/main" src="/resources/custom/js/ajax.js"></script>
<script data-main="/resources/js/main" src="/resources/custom/js/function.js"></script>
<!-- <script data-main="/resources/js/main" src="/resources/assets/lib/jquery-loadTemplate/jquery.loadTemplate-1.4.4.min.js"></script> -->
<script data-main="/resources/js/main" src="/resources/lib/jquery-loadTemplate/jquery.loadTemplate-1.4.4.js"></script>
<!-- 부트스트랩 테마 Bootflat JS -->
<script src="/resources/assets/lib/bootflat/js/icheck.min.js"></script>
<script src="/resources/assets/lib/bootflat/js/jquery.fs.selecter.min.js"></script>
<script src="/resources/assets/lib/bootflat/js/jquery.fs.stepper.min.js"></script>
</head>
<body>
<!-- navbar-inverse -->
<div class="container-fluid">
	<div id="sidebar-top"></div>
	<div id="main" class="row center-block"></div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$("#sidebar-top").load("/sidebar-top");
	$("#main").load("${mainContent}");
});
$(document).pjax("a", "#main");
</script>
</body>
</html>