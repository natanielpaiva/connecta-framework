package br.com.cds.connecta.framework.core.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import br.com.cds.connecta.framework.core.controller.common.InitController;
import br.com.cds.connecta.framework.core.domain.ExceptionEnum;
import br.com.cds.connecta.framework.core.entity.AbstractBaseEntity;
import br.com.cds.connecta.framework.core.exeception.SystemException;

/**
 * 
 * 
 * URL'S: 
 * GET /recurso - Obtém a lista de resources <br>
 * GET /recurso/id - Obtém um unico recurso pelo id informado <br>
 * POST /recurso - Cria um novo recurso <br>
 * POST /recurso/upload - Cria um novo recurso usando upload de arquivos <br>
 * PUT /recurso/id - Atualiza um recurso específico <br>
 * PUT /recurso/upload/id - Atualiza um recurso , com upload de arquivos <br>
 * DELETE /recurso/id - Remove um recurso pelo id AbstractBaseBean - Pode ser
 * uma Entity(JPA) ou Bean
 */


public abstract class AbstractBaseController<E extends AbstractBaseEntity> extends
		InitController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected E getMapping(@PathVariable Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return get(id, request, response);
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected List<E> listMapping(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return list(request, response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected void deleteMapping(@PathVariable Long id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		delete(id, request, response);
	}
	
	
	

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected E saveMapping(@RequestBody E data, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return save(data, request, response);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected void updateMapping(@PathVariable Long id,
			@RequestBody E resource, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		update(id, resource, request, response);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected E createWithUploadMapping(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		return createWithUpload(multipartRequest, request, response);
	}

	@RequestMapping(value = "/upload/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	protected E updateWithUploadMapping(@PathVariable Long id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

		E out = updateWithUpload(id, multipartRequest, request, response);
		if (out == null) {
			// quando o resource a ser atualizado nao existe,
			throw new SystemException(ExceptionEnum.NOT_FOUND);
		}
		return out;
	}
	
	
	

	/**
	 * Executa a busca  por id
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract E get(Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/**
	 * Permite fazer a listagem de resources
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract List<E> list(HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/**
	 * Permite a criação de um resource
	 * 
	 * @param resource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract E save(E entity, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	/**
	 * Permite a criaçao de resources anexados a arquivos
	 * 
	 * @param multipartRequest
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract E createWithUpload(
			MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * Permite o update de um resource específico
	 * 
	 * @param id
	 * @param resource
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract E update(Long id, E entity,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * Permite o update de um resource que possui um arquivo anexo
	 * 
	 * @param id
	 * @param multipartRequest
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected abstract E updateWithUpload(Long id,
			MultipartHttpServletRequest multipartRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception;

	/**
	 * 
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	protected abstract void delete(Long id, HttpServletRequest request,
			HttpServletResponse response) throws Exception;
	
	


}
