<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/styles.css">
<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/jquery-ui.min.css">
<script src="${pageContext.request.contextPath}/resources/jquery-3.0.0.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/jquery-ui.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$("#dialog1").dialog({
			autoOpen: false
	});
	$("#addprerequisito").on("click", function() {
		$("#dialog1").dialog("open");
	});
	$("#dialog2").dialog({
		autoOpen: false
	});
	$("#dialog3").dialog({
		autoOpen: false
	});
	$("#dialog4").dialog({
		autoOpen: false
	});
	$("#esamimedicobutton").on("click", function() {
		$("#dialog3").dialog("open");
	});
	$("#addesamebutton").on("click", function() {
		$("#dialog4").dialog("open");
	});
	$("#addtipesame").on("click", function() {
		$("#dialog2").dialog("open");
	});
	$('#aggiungiprerequisito').submit(function(e) {
		var frm = $('#aggiungiprerequisito');
		e.preventDefault();
	    var data = {}
	    var Form = this;
	
	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	    alert(JSON.stringify(data));
	$.ajax({
	    contentType : 'application/json; charset=utf-8',
	    type: frm.attr('method'),
	    url: frm.attr('action'),
	    dataType : 'json',
	    data : JSON.stringify(data),
	    success : function(callback){
	    	getPrerequisiti();
	    	getTipEsami();
	    },
	    error : function(){
	        alert("Error");
	    }
	});
	});
	$('#esami').submit(function(e) {
		var frm = $('#esami');
		e.preventDefault();
	    var data = {}
	    var Form = this;
	
	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	   alert(JSON.stringify(data));
	$.ajax({
		contentType : 'application/json; charset=utf-8',
	    type: frm.attr('method'),
	    url: frm.attr('action'),
	    dataType : 'json',
	    data : JSON.stringify(data),
	    success : function(callback){
			alert('success');
	    },
	    error : function(){
	        alert("Error");
	    }
	});
	});
	$('#esamimedico').submit(function(e) {
		var frm = $('#esamimedico');
		e.preventDefault();
	    var data = {}
	    var Form = this;
	
	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	$.ajax({
	    contentType : 'application/json; charset=utf-8',
	    type: frm.attr('method'),
	    url: frm.attr('action'),
	    dataType : 'json',
	    data : JSON.stringify(data),
	    success : function(data){
	    	alert(data);	
	    },
	    error : function(){
	        alert("Error");
	    }
	});
	});
	$('#aggiungitipesame').submit(function(e) {
		var frm = $('#aggiungitipesame');
		e.preventDefault();
	    var data = {}
	    var Form = this;
	
	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	$.ajax({
	    contentType : 'application/json; charset=utf-8',
	    type: frm.attr('method'),
	    url: frm.attr('action'),
	    dataType : 'json',
	    data : JSON.stringify(data),
	    success : function(callback){
	    	getTipEsami();
	    },
	    error : function(){
	        alert("Error");
	    }
	});
	});
	$("#submitprereq").click(function(e) {
		var email = $("#prereqnome").val();
		var name = $("#prereqdesc").val();
	});
function getTipEsami(){
    jQuery.support.cors = true;
    $.ajax(
    {
        type: "GET",
        url: "${pageContext.request.contextPath}/json/tipesami/consulta",
        data: "{}",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        cache: false,
        success: function (data) {
            
        var trHTML = '';
        
        for(var i=0;i<data.length;i++){
            var obj = data[i];
            trHTML += '<tr>';
            for(var key in obj){
                var attrName = key;
                var attrValue = obj[key];
                trHTML += '<td>' + attrValue + '</td>';
            }
            trHTML += '</tr>';
        }
        
        $('#tipesami').html(trHTML);
        
        },
        
        error: function (msg) {
            
            alert(msg.responseText);
        }
    });
}
function getPrerequisiti(){
	 jQuery.support.cors = true;
	    $.ajax(
	    {
	        type: "GET",
	        url: "${pageContext.request.contextPath}/json/prerequisiti/list",
	        data: "{}",
	        contentType: "application/json; charset=utf-8",
	        dataType: "json",
	        cache: false,
	        success: function (data) {
	            
	        var trHTML = '';
            trHTML += '<tr>';
	        for(var i=0;i<data.length;i++){
	            var obj = data[i];
	            trHTML += '<td>' + '<input type="checkbox" name="prerequisitiarr" value="'+obj['id']+'">' + obj['descr']+  '</td>';
	        }
	        trHTML += '</tr>';
	        
	        $('#prerequisiti').html(trHTML);
	        
	        },
	        
	        error: function (msg) {
	            
	            alert(msg.responseText);
	        }
	    });
}
getTipEsami();
getPrerequisiti();
})

</script>
<script type="text/javascript">
$(function(){
  $('a[href="#"]').on('click', function(e){
    e.preventDefault();
  });
  
  $('#menu > li').on('mouseover', function(e){
    $(this).find("ul:first").show();
    $(this).find('> a').addClass('active');
  }).on('mouseout', function(e){
    $(this).find("ul:first").hide();
    $(this).find('> a').removeClass('active');
  });
  
  $('#menu li li').on('mouseover',function(e){
    if($(this).has('ul').length) {
      $(this).parent().addClass('expanded');
    }
    $('ul:first',this).parent().find('> a').addClass('active');
    $('ul:first',this).show();
  }).on('mouseout',function(e){
    $(this).parent().removeClass('expanded');
    $('ul:first',this).parent().find('> a').removeClass('active');
    $('ul:first', this).hide();
  });
});
</script>
</head>
<body>
<nav>
 	<div class="wrapper">
      <ul id="menu" class="clearfix">
        <li><a href="#">Home</a></li>
        <li><a href="#">Amministrazione</a>
          <ul>
            <li class="gold"><a id="addtipesame" href="#">Aggiungi Tip. Esame</a></li>
            <li class="gold"><a id="addprerequisito" href="#">Aggiungi Prerequisito</a></li>
            <li class="gold"><a id="esamimedicobutton" href="#">Esami effett. medico</a></li>
            <li class="gold"><a id="addesamebutton" href="#">Aggiungi esame</a></li>
          </ul>
        </li>
      </ul>
    </div>
</nav>
<div id="page1">
<table id="tipesami" border='1'>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Codice</th>
        <th>Descrizione</th>
        <th>Costo</th>
    </tr>
</table>
</div>
<div id="page2">
	<div id="dialog4" title="Aggiungi Esame" >
		<springForm:form method="POST" id="esami" commandName="esameform" action="${pageContext.request.contextPath}/json/esami/aggiungi">
		<label>ID TIPOLOGIA ESAME:</label>
		<springForm:input path="tipesame"/>
		<label>ID MEDICO:</label>
		<springForm:input path="medico"/>
		<input id="submitesame" type="submit" value="Submit">
		</springForm:form>
	</div>
	<div id="dialog2" title="Aggiungi Esame">
	<springForm:form method="POST" commandName="tipesame" id="aggiungitipesame" action="${pageContext.request.contextPath}/json/tipesami/aggiungi">
		<table>
			<tr>
				<td>Nome</td>
				<td><springForm:input path="nome" /></td>
			</tr>
			<tr>
				<td>Codice:</td>
				<td><springForm:input path="cod" /></td>
			</tr>
			<tr>
				<td>Descrizione:</td>
				<td><springForm:input path="descr" /></td>
			</tr>
			<tr>
				<td>Costo:</td>
				<td><springForm:input path="costo" /></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit" value="Aggiungi" id="aggiungtipesamebutton"></td>
			</tr>
		</table>
	</springForm:form>
	</div>
	<div id="dialog1" title="Aggiungi Prerequisito" >
		<springForm:form method="post" id="aggiungiprerequisito" commandName="prerequisito" action="${pageContext.request.contextPath}/json/prerequisiti/aggiungi">
		<label>Nome:</label>
		<springForm:input path="nome"/>
		<label>Descrizione:</label>
		<springForm:input path="descr"/>
		<input id="submitprereq" type="submit" value="Submit">
		</springForm:form>
	</div>
	<div id="dialog3" title="Esami effettuati dal medico" >
		<springForm:form method="post" id="esamimedico" commandName="medico" action="${pageContext.request.contextPath}/json/esami/medico">
		<label>Nome:</label>
		<springForm:input path="nome"/>
		<label>Cognome:</label>
		<springForm:input path="cognome"/>
		<input id="submitesamimedico" type="submit" value="Submit">
		</springForm:form>
	</div>
</body>
</html>
