package com.example.gestortareas.persistencia.crud;

import com.example.gestortareas.persistencia.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioCrudRepository extends CrudRepository<Usuario,Integer> {



     Usuario findUsuarioByIdUsuario(int idUsuario);

     Optional<Usuario> findByCorreo(String correo);






    /*
    //consulatas con finBy
    // Método de consulta para buscar productos por categoría y ordenar por nombre ascendente
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    //Metodo de consulta para buscar productos por el id del producto solo te retorna un la columna "Nombre"
    List<Producto> findNombreByIdProducto(int idProducto);


    //Metodo de consulta para busacar productos por su codigo de barras
    List <Producto> findByCodigoBarras(String CodigoBarras);

    //Metodo de consulta para buscar productos segun su stock y su estado
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, int estado);
*/

}
