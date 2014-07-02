<%@page import="ec.gob.senagua.controladores.LoadTreeMenuControlador"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<link href="../../css/jquery.treeview.css" media="screen"
	rel="stylesheet" type="text/css"></link>

<script type="text/javascript">
	$(document).ready(function() {
		$("#tree").treeview({
			collapsed : true,
			animated : "medium",
			control : "#sidetreecontrol",
			persist : "location"
		});
	});
</script>

<div id="sidetreecontrol" style="clear: both; margin-top: 20px; margin-bottom: 10px">
	<a href="?#">Colapsar Todo</a> | <a href="?#">Expandir Todo</a>
</div>
<div style="clear: both;">
	<%--
		String opciones = new LoadTreeMenuBacking().getMenuHtml();
		
			out.print(opciones != null ? opciones : "");
		
	--%>
</div>



