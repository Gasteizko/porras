<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>

<%@ include file="../jspf/header.jspf"%>
<body>
<%@ include file="../jspf/navbar.jspf"%>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Dashboard</h1>
        </div><!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="col-lg-4 col-md-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-fire fa-4x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">26</div>
                            <div class="panel-title-custom">Nuevas porras!</div>
                        </div>
                    </div>
                </div>
                <div class="panel-body panel-body-custom">
                    <div class="list-group">
                        <a href="#" class="list-group-item text-center">
                            <h4 class="list-group-item-heading"><img class="pull-left" src="${s}/img/madridt.png" alt="Club1" height="40px"/> R. Madrid - Barsa <img class="pull-right" src="${s}/img/barsa.png" alt="Club1" height="40px"/></h4>
                            <p class="list-group-item-text">1045 participantes</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Equipos que descienden</h4>
                            <p class="list-group-item-text">32 participantes</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Próximo entrenador despedido</h4>
                            <p class="list-group-item-text">21 participantes</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Nº expulsados en la jornada</h4>
                            <p class="list-group-item-text">165 participantes</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Equipos que juegan Champions</h4>
                            <p class="list-group-item-text">34 participantes</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Leganés - Málaga</h4>
                            <p class="list-group-item-text">76 participantes</p>
                        </a>
                    </div>
                </div>
                <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Más</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-4 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-check fa-4x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">3</div>
                            <div class="panel-title-custom">Porras ganadas!</div>
                        </div>
                    </div>
                </div>
                <div class="panel-body panel-body-custom">
                    <div class="list-group">
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">R. Madrid - Muchen</h4>
                            <p class="list-group-item-text">30€ ganados</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Equipos que descienden</h4>
                            <p class="list-group-item-text">8€ ganados</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Próximo entrenador despedido</h4>
                            <p class="list-group-item-text">6€ ganados</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Nº expulsados en la jornada</h4>
                            <p class="list-group-item-text">3€ ganados</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Equipos que juegan Champions</h4>
                            <p class="list-group-item-text">2€ ganados</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Leganés - Málaga</h4>
                            <p class="list-group-item-text">9€ ganados</p>
                        </a>
                    </div>
                </div>
                <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Más</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-4 col-md-6">
            <div class="panel panel-red">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-times-circle fa-4x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">5</div>
                            <div class="panel-title-custom">Porras perdidas!</div>
                        </div>
                    </div>
                </div>
                <div class="panel-body panel-body-custom">
                    <div class="list-group">
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">R. Madrid - Barsa</h4>
                            <p class="list-group-item-text">1 cerveza perdida</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Próximo presidente de EEUU</h4>
                            <p class="list-group-item-text">Has ganado 1 colleja</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Próximo entrenador despedido</h4>
                            <p class="list-group-item-text">8€ perdidos</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Espanyol - Milán</h4>
                            <p class="list-group-item-text">20€ perdidos</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Sevilla - Betis</h4>
                            <p class="list-group-item-text">2€ perdidos</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Leganés - Málaga</h4>
                            <p class="list-group-item-text">5€ perdidos</p>
                        </a>
                    </div>
                </div>
                <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Más</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
        <div class="col-lg-4 col-md-6">
            <div class="panel panel-green">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            <i class="fa fa-user fa-4x"></i>
                        </div>
                        <div class="col-xs-9 text-right">
                            <div class="huge">2</div>
                            <div class="panel-title-custom">Mis porras!</div>
                        </div>
                    </div>
                </div>
                <div class="panel-body panel-body-custom">
                    <div class="list-group">
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Torneo LOL</h4>
                            <p class="list-group-item-text">3€ apostados</p>
                        </a>
                        <a href="#" class="list-group-item">
                            <h4 class="list-group-item-heading">Torneo FIFA</h4>
                            <p class="list-group-item-text">8€ apostados</p>
                        </a>
                    </div>
                </div>
                <a href="#">
                    <div class="panel-footer">
                        <span class="pull-left">Más</span>
                        <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                        <div class="clearfix"></div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="../jspf/footer.jspf"%>
