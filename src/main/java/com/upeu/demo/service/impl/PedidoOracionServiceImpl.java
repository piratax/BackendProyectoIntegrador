
package com.upeu.demo.service.impl;


import com.upeu.demo.entity.PedidoOracion;
import com.upeu.demo.repository.PedidoOracionRepository;
import com.upeu.demo.service.PedidoOracionService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author franc
 */
@Service
public class PedidoOracionServiceImpl implements PedidoOracionService{
    @Autowired
    private PedidoOracionRepository pedidoOracionRepository;

    @Transactional
    @Override
    public List<PedidoOracion> findAll() {
        return (List<PedidoOracion>) pedidoOracionRepository.findAll();
    }

    @Override
    public PedidoOracion findById(Long id) {
        return pedidoOracionRepository.findById(id).orElse(null);
    }

    @Override
    public PedidoOracion save(PedidoOracion pedidoOracion) {
        return pedidoOracionRepository.save(pedidoOracion);
    }

    @Override
    public void delete(PedidoOracion pedidoOracion) {
        pedidoOracionRepository.delete(pedidoOracion);
    }

    @Override
    public void deleteById(Long id) {
        pedidoOracionRepository.deleteById(id);
    }
}
