# porras

porras es una plataforma donde la gente pueda realizar apuestas entre grupos, vamos las porras de toda la vida.

Se podrá apostar sobre cualquier cosa, ya sea deportes como fútbol, baloncesto, tenis, etc, e-sports, retos, en definitiva, cualquier tema que los usuarios quieran crear.

Hay dos tipos principales de porras, las públicas y las privadas, sus diferencias se explican más adelante.

## Usuarios

- Perfil con datos básicos
- Gente con la que he participado, búsqueda de personas
- Historial de porras, ganancias, pérdidas, resultados…
- Usuario administrador para validar porras, controlar resultados, gestión de usuarios, etc

## Porra

- Creación, borrado, modificación…

- Tipos de porra:
  - según resultado:
    - **Binaria**: si/no, pierde/gana, puede/no puede, etc
    - **Cuantitativa**: 1-0, 4-5, etc
    - **Cualitativa**: un nombre propio, cualquier texto…
  - según visibilidad:
    - **públicas**:

      Pueden ser creadas por los administradores (apuestas más comunes como partidos de football, etc) y por los usuarios pero con previa validación por parte de los administradores para que puedan ver si es una porra viable, es decir, que se puede comprobar el resultado de alguna manera.

      Sólo se podrá apostar con dinero que previamente haya sido ingresado en la cuenta, con el fin de evitar impagos de tramposos.

    - **privadas**:

      La puede crear cualquier usuario, pudiendo apostar sobre cualquier cosa, invitar a cualquier persona, personalizar sus ajustes como quiera…

      Para participar se necesita acceder con un enlace único para dicha porra, al acceder a dicho enlace se pedirá iniciar sesión o en su defecto registrarse, una vez iniciada la sesión el usuario podrá participar en la porra.

      Se basan en la confianza que hay entre los participantes, por lo que, se puede apostar sobre cualquier tema y con cualquier moneda, el creador tendrá un papel muy importante ya que invitará a la gente a participar y deberá decidir quién/es es el ganador al finalizar la porra.

- Datos y ajustes:

  - nombre
  - descripción y foto
  - visibilidad (pública o privada)
  - tipo (binaria, cuantitativa o cualitativa)
  - posibles apuestas (si /no, pierde/gana, etc)
  - participantes
  - posibilidad de apostar los mismo
  - cantidad máxima de participantes
  - cantidad a apostar
  - fecha de finalización

## Vistas

- **Inicio**, simple, con un fondo bonito y una explicación corta de que es la plataforma y que se puede hacer con ella. Desde aquí se podrá acceder a la pantalla de login.
- **Dashboard**: con una vista rápida de las últimas porras públicas, en las que se ha participado y que todavía no han finalizado, las invitaciones de amistad o a porras todavía no aceptadas, etc
- **Porras**:
  - vista con una lista o mosaico de porras
  - Capacidad de filtrar por diferentes campos; públicas, privadas, en las que está participando el usuario, las caducadas, las creadas, las invitaciones recibidas a participar, etc.
- **Porra**: 
  - vista de una porra en concreto, con toda su información.
  - Si el usuario logueado es el creador podrá modificarla.
  - Posibilidad de compartir la porra mediante un enlace (solo para el creador).
- **Perfil de usuario**:
  - Información básica del usuario, pudiendo modificar algunos campos.
  - Porras en las que ha participado.
  - Privacidad, visibilidad de mis apuestas para los demás.
  - Dinero disponible en la plataforma y capacidad de ingresar más…paypal…
- **Adminsitrador**
