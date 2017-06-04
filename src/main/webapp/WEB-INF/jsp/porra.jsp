<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ include file="../jspf/header.jspf"%>
<body>
<%@ include file="../jspf/navbar.jspf"%>
<div class="container container-bg">
    <br />

    <!-- Titulo  -->
    <div class="row">
        <h1 class="text-center"><strong>Real Madrid - Real Sociedad</strong></h1>
    </div>
    <br />

    <!-- Foto equipos e información -->
    <div class="row">
        <div class="col-md-3">
            <img src="${s}/img/madridt.png" class="img-responsive center-block" alt="Club1" width="120" height="120" />
        </div>

        <div class="col-md-6">
            <h4 class="text-center"><strong>Tipo: </strong> Resultados</h4>
            <h4 class="text-center"><strong>Apuesta mínima:</strong> 5 €</h4>
            <h4 class="text-center"><strong>Equipo 1:</strong> Real Madrid</h4>
            <h4 class="text-center"><strong>Equipo 2:</strong> Real Sociedad</h4>
        </div>

        <div class="col-md-3">
            <img src="${s}/img/rsociedad.png" class="img-responsive center-block" alt="Club2" width="120" height="120" />
        </div>
    </div>

    <br />

    <!-- Participantes -->
    <div class="row text-center">
        <div class="table-responsive">
            <table class="table table-hover table-bg">
                <thead>
                <tr>
                    <th class="text-center">Participante</th>
                    <th class="text-center">Apuesta</th>
                    <th class="text-center">Cantidad</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Pepe</td>
                    <td>3-2</td>
                    <td>5 €</td>
                </tr>
                <tr>
                    <td>Pedro</td>
                    <td>1-3</td>
                    <td>15 €</td>
                </tr>
                <tr>
                    <td>Lopez</td>
                    <td>1-4</td>
                    <td>8 €</td>
                </tr>
                <tr>
                    <td>Alberto</td>
                    <td>2-2</td>
                    <td>20 €</td>
                </tr>
                <tr>
                    <td>Pepa</td>
                    <td>3-4</td>
                    <td>10 €</td>
                </tr>
                <tr>
                    <td>Pepe</td>
                    <td>3-2</td>
                    <td>5 €</td>
                </tr>
                <tr>
                    <td>Pedro</td>
                    <td>1-3</td>
                    <td>15 €</td>
                </tr>
                <tr>
                    <td>Lopez</td>
                    <td>1-4</td>
                    <td>8 €</td>
                </tr>
                <tr>
                    <td>Alberto</td>
                    <td>2-2</td>
                    <td>20 €</td>
                </tr>
                <tr>
                    <td>Pepa</td>
                    <td>3-4</td>
                    <td>10 €</td>
                </tr>
                <tr>
                    <td>Pepe</td>
                    <td>3-2</td>
                    <td>5 €</td>
                </tr>
                <tr>
                    <td>Pedro</td>
                    <td>1-3</td>
                    <td>15 €</td>
                </tr>
                <tr>
                    <td>Lopez</td>
                    <td>1-4</td>
                    <td>8 €</td>
                </tr>
                <tr>
                    <td>Alberto</td>
                    <td>2-2</td>
                    <td>20 €</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Botones -->
    <div class="row">
        <div class="col-md-4 text-center"><button type="button" class="btn btn-success">Apostar</button></div>
        <div class="col-md-4 text-center"><button type="button" class="btn btn-warning">Compartir</button></div>
        <div class="col-md-4 text-center"><button type="button" class="btn btn-primary">Editar</button></div>
    </div>

    <br /><br />

</div> <!-- Cierra div container -->

</body>
<%@ include file="../jspf/footer.jspf"%>
