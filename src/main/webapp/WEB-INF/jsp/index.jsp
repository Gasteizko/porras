<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>
<body class="bodyLogin">
<%@ include file="../jspf/navbarIndex.jspf"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-8" id="zonaFormulario">
            <!--Formulario -->
            <div class="jumbotron" id="jumboIndex">
                <h1>La nueva forma de apostar </h1>
                <p> El sitio ideal para hacer las porras con tus amigos </p>
            </div>

            <div class="row">
                <div class="col-md-1" id="zonaFormulario"></div>
                <div class="col-md-5" id="zonaFormulario">
                    <div class="panel panel-primary" id="panelLogin" >
                        <div class="panel-heading" id="panelHead"><div class="text-center"><strong>Entrar en Porras</strong></div></div>
                        <div class="panel-body">
                            <form name="f" method="POST" action="/login" autocomplete="on" class="form-horizontal" role="form">
                                <div class="form-group" id="formUser">
                                    <div class="container-fluid">
                                        <input id="usuario" type="text" name="user" required="required" class="form-control" placeholder="Usuario" maxlength="10"/>
                                    </div>
                                </div>
                                <div class="form-group" id="formPass">
                                    <div class="container-fluid">
                                        <input id="password" type="password" name="pass" required="required" class="form-control" placeholder="Contraseña" maxlength="10"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <center>
                                        <div class="center-block"><button type="submit" class="btn btn-primary btn-index" name="formLogin" value="Sign in"><strong>Iniciar sesión</strong></button></div>
                                    </center>
                                </div>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6" id="zonaFormulario"></div>
            </div>
        </div>
        <!--Fin formulario -->
        <div class="col-md-1" id="zonaFormulario"></div>
        <div class="col-md-3" id="zonaFormulario">
            <!--Formulario -->
            <div class="row">
                <div class="col-md-11" id="zonaFormulario">
                    <div class="panel panel-primary" id="panelPorras">
                        <div class="panel-heading" id="panelHead"><div class="text-center"><strong>Porras más populares <span class="glyphicon glyphicon-fire"></span></strong></div></div>
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked" id="lista">
                                <li><a href="#"><center><span class="glyphicon glyphicon-flash" id="flash"></span> Real Madrid - Ath. Bilbao</center></a></li>
                                <li><a href="#"><center>Atlético de Madrid - Sevilla</center></a></li>
                                <li><a href="#"><center>Barcelona - Valencia C.F.</center></a></li>
                                <li><a href="#"><center><span class="glyphicon glyphicon-flash" id="flash"></span> Deportivo - Celta de Vigo</center></a></li>
                                <li><a href="#"><center>Leganés - Málaga</center></a></li>
                                <li><a href="#"><center><span class="glyphicon glyphicon-flash" id="flash"></span> Equipos que descienden</center></a></li>
                                <li><a href="#"><center>Equipos que juegan Champions</center></a></li>
                                <li><a href="#"><center><span class="glyphicon glyphicon-flash" id="flash"></span> Próximo entrenador despedido</center></a></li>
                                <li><a href="#"><center>Nº expulsados en la jornada</center></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-1" id="zonaFormulario"></div>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="../jspf/footer.jspf"%>

