package com.dyaminimarket.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dyaminimarket.dao.DetalleCotizacionRepository;
import com.dyaminimarket.dao.FormaPagoRepository;
import com.dyaminimarket.dao.MonedaRepository;
import com.dyaminimarket.dao.ProductoRepository;
import com.dyaminimarket.dto.DetalleCotizacionDTO;

import com.dyaminimarket.models.DetalleCotizacion;

@Service
public class DetalleCotizacionService {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private MonedaRepository monedaRepository;
	@Autowired
	private FormaPagoRepository formaPagoRepository;
	@Autowired
	private DetalleCotizacionRepository detalleRepository;
	
	@Autowired
	private ProductoService productoService;
	@Autowired
	private MonedaService monedaService;
	@Autowired
	private FormaPagoService formaPagoService;

	public DetalleCotizacionDTO convertToDTO(DetalleCotizacion entity) {
		DetalleCotizacionDTO dto = new DetalleCotizacionDTO();
		dto.setId(entity.getId());
		dto.setCantidad(entity.getCantidad());
		dto.setPrecioUnitario(entity.getPrecioUnitario());

		if (entity.getCodProducto() != null)
			dto.setCodProducto(productoService.getProductoById(entity.getCodProducto().getId()).orElse(null));

		if (entity.getCodMoneda() != null)
			dto.setCodMoneda(monedaService.getMonedaById(entity.getCodMoneda().getId()).orElse(null));

		if (entity.getCodFormaPago() != null)
			dto.setCodFormaPago(formaPagoService.getFormaPagoById(entity.getCodFormaPago().getId()).orElse(null));

		return dto;
	}

	public DetalleCotizacion convertToEntity(DetalleCotizacionDTO dto) {
		DetalleCotizacion entity = new DetalleCotizacion();
		entity.setId(dto.getId());
		entity.setCantidad(dto.getCantidad());
		entity.setPrecioUnitario(dto.getPrecioUnitario());

		if (dto.getCodProducto() != null)
			productoRepository.findById(dto.getCodProducto().getId()).ifPresent(entity::setCodProducto);

		if (dto.getCodMoneda() != null)
			monedaRepository.findById(dto.getCodMoneda().getId()).ifPresent(entity::setCodMoneda);

		if (dto.getCodFormaPago() != null)
			formaPagoRepository.findById(dto.getCodFormaPago().getId()).ifPresent(entity::setCodFormaPago);

		return entity;
	}
	public List<DetalleCotizacionDTO> getAllDTO() {
        return detalleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<DetalleCotizacionDTO> getById(Integer id) {
        return detalleRepository.findById(id).map(this::convertToDTO);
    }
}
