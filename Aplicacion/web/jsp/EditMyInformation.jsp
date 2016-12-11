<%@page import="com.ipn.mx.model.entities.Usuario"%>
<%@page import="com.ipn.mx.model.dao.UsuarioDAO"%>
<% 
    Usuario datosUsuario = (Usuario) request.getSession().getAttribute("datos");
%>
        <!-- Modal Edit information user -->
        <div class="modal fade" id="editarPerfil" tabindex="-1" role="dialog" aria-labelledby="perfilModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title" id="perfilModalLabel">Editar mi informaci&oacute;n:</h4>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-1"></div>
                            <div class="col-md-9">
                                <div class="row">
                                    <%
                                        if (datosUsuario == null) {
                                    %>
                                    <div class="col-md-offset-2 col">
                                        <p>Ha ocurrido un error al buscar sus datos de usuario.<br></p>
                                        <%=(String)request.getSession().getAttribute("nombre_usuario")%><br>
                                        <%=(String)request.getSession().getAttribute("clave_usuario")%><br>
                                    </div>
                                    <%
                                        } else {
                                    %>
                                    <form id="editMyPerfil" name="editMyPerfil">
                                        <div class="row-fluid">
                                            <div class="form-group">
                                                <label for="nombre_cliente" class="control-label">Nombre: </label>
                                                <div id="input">
                                                    <input type="text" class="form-control" id="nombre_cliente" name="nombre_cliente" value="<%=datosUsuario.getNombreUsuario()%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="apPaterno_cliente" class="control-label">Apellido paterno:</label>
                                                <div id="input">
                                                    <input type="text" class="form-control" id="apPaterno_cliente" name="apPaterno_cliente" value="<%=datosUsuario.getPaternoUsuario()%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="apMaterno_cliente" class="control-label">Apellido materno:</label>
                                                <div id="input">
                                                    <input type="text" class="form-control" id="apMaterno_cliente" name="apMaterno_cliente" value="<%=datosUsuario.getMaternoUsuario()%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="correo_cliente" class="control-label">Correo:</label>
                                                <div id="input">
                                                    <input type="email" class="form-control" id="correo_cliente" name="correo_cliente" value="<%=datosUsuario.getEmail()%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="nickUsuario_cliente" class="control-label">Nick de usuario: </label>
                                                <div id="input">
                                                    <input type="text" class="form-control" id="nickUsuario_cliente" name="nickUsuario_cliente" value="<%=datosUsuario.getNickUsuario()%>">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="claveUsuario_cliente" class="control-label">Clave de usuario: </label>
                                                <div id="input">
                                                    <input type="password" class="form-control" id="claveUsuario_cliente" name="claveUsuario_cliente" value="<%=datosUsuario.getClaveUsuario()%>">
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                    <% } %>
                                </div>
                                <div class="col-md-1"></div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-info" data-dismiss="modal">Enviar mi informacion por correo</button>
                        <button type="button" class="btn btn-primary" name="sendRequest" id="sendRequest" name="sendRequest">Actualizar mi informaci&oacute;n</button>
                    </div>
                </div>
            </div>
        </div>