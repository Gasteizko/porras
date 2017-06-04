<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ include file="../jspf/header.jspf"%>
<body>
<%@ include file="../jspf/navbar.jspf"%>
<div class="listaPorritas">
    <div class="col-xs-4" id="porras1">
        <label for="col-xs-4">Buscador: </label>
        <input type="text" class="form-control" id="col-xs-4" placeholder="Titulo de la porra"></input>
    </div>

    <div class="radio" id="porras2" >
        <label><input type="radio" name="optradio">Porras públicas</input></label>
    </div>

    <div class="radio" id="porras3">
        <label><input type="radio" name="optradio">Porras privadas</input></label>
    </div>

    <div class="radio" id="porras4">
        <label><input type="radio" name="optradio">Porras en las que participas</input></label>
    </div>
</div>

<div class="table-responsive">
    <table class="table">
        <tbody>
        <tr>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
        </tr>
        <tr>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
        </tr>
        <tr>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
            <td>
                <img src="${s}/img/madrid.png" class="img-responsive center-block" alt="Cinque Terre" width="90" height="70"></img>
                <p class="text-center">Partido Madrid</p>
            </td>
        </tr>
        </tbody>
    </table>
</div>
</body>
<%@ include file="../jspf/footer.jspf"%>