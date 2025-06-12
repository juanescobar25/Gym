package com.sistemagym.gym.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemagym.gym.Repository.IRepositoryUsuario;
import com.sistemagym.gym.models.Usuario;

@Service
public class UsuarioServices {
    @Autowired 
    IRepositoryUsuario repository;

    //Listar los metodos que activaran las consultas en la base de datos

    //Metodo Guardar
    public Usuario guardarUsuario(Usuario datosUsuario) throws Exception{
        try{
            //Validar los datos de entreda
            return this.repository.save(datosUsuario);
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar todos los registros
    public List<Usuario> buscarTodosUsuarios() throws Exception{
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para buscar por Id
    public Usuario buscarusuarioPorId(Integer idUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repository.findById(idUsuario);

            if (usuarioBuscado.isPresent()) {
                return usuarioBuscado.get();
            } else {
                throw new Exception("El usuario buscado no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para modificar por Id
    public Usuario modificarusaurio(Integer id, Usuario datosUsuario) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado = this.repository.findById(id);
            if (usuarioBuscado.isPresent()) {
                usuarioBuscado.get().setTelefono(datosUsuario.getTelefono());
                usuarioBuscado.get().setCorreo(datosUsuario.getCorreo());
                return this.repository.save(usuarioBuscado.get());
            } else {
                throw new Exception("El usuario buscado no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //Metodo para eliminar por Id
    public boolean eliminarUsuario(Integer id) throws Exception{
        try {
            Optional<Usuario> usuarioBuscado=this.repository.findById(id);
            if (usuarioBuscado.isPresent()) {
                this.repository.deleteById(id);
                return true;
            } else {
                throw new Exception("El usuario buscado no esta en BD");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
