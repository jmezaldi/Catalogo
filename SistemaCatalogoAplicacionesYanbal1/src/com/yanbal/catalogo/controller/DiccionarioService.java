package com.yanbal.catalogo.controller;

import java.util.List;
import java.util.ListIterator;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.yanbal.catalogo.bean.AtributoXEntidad;
import com.yanbal.catalogo.bean.Diccionario;
import com.yanbal.catalogo.bean.Entidad;
import com.yanbal.catalogo.bean.Usuario;

@ManagedBean(name = "diccionarioService")
@ApplicationScoped
public class DiccionarioService {

	public TreeNode createDiccionario(List<Entidad> entidad,
			List<AtributoXEntidad> atributo) {
		ListIterator<Entidad> litr_entidad = entidad.listIterator();
		ListIterator<AtributoXEntidad> litr_atributo = null;
		TreeNode root = new DefaultTreeNode(new Diccionario("Files", "-",
				"Folder"), null);
		TreeNode nodeEntidad = null;
		TreeNode nodeAtributo;

		while (litr_entidad.hasNext()) {
			Entidad element = litr_entidad.next();
			String ID = element.getId().toString();
			String ID_BD = element.getIdBaseDatos().getId().toString();
			if (ID_BD.equals("22")) {
				String NOMBRE = element.getNombre();
				String DESCRIPCION = element.getDescripcion();
				String DATA_SENSIBLE = element.getDataSensible().toString();

				nodeEntidad = new DefaultTreeNode(new Diccionario(NOMBRE,
						DESCRIPCION, DATA_SENSIBLE), root);
				litr_atributo = atributo.listIterator();
				while (litr_atributo.hasNext()) {
					AtributoXEntidad elementAtributo = litr_atributo.next();
					String ID_ENTI = elementAtributo.getIdEntidad().getId()
							.toString();
					String NOM_ATT = elementAtributo.getNombre();
					String DES_ATT = elementAtributo.getDescripcion();
					if (ID.equals(ID_ENTI)) {
						nodeAtributo = new DefaultTreeNode("nodeEntidad",
								new Diccionario(NOM_ATT, DES_ATT, " "),
								nodeEntidad);
					}
				}
			}
		}

		return root;
	}

}
