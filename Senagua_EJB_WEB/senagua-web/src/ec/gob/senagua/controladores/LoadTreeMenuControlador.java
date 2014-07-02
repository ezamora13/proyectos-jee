package ec.gob.senagua.controladores;

import java.io.File;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ec.gob.senagua.modelo.RhGlbOpcionesMenu;
import ec.gob.senagua.modelo.RhGlbPermisosOpcionesMenuPerfil;
import ec.gob.senagua.servicios.RhGlbOpcionesMenuLocal;
import ec.gob.senagua.servicios.RhGlbPermisosOpcionesMenuPerfilLocal;


@Named
public class LoadTreeMenuControlador {
	private List<RhGlbOpcionesMenu> opciones;

	private List<RhGlbPermisosOpcionesMenuPerfil> items;

	@EJB
	private RhGlbOpcionesMenuLocal opcionesServicio;

	@EJB
	private RhGlbPermisosOpcionesMenuPerfilLocal itemsServicio;

	private String xmlTemplate;

	public String menuHtml;

	private String escape = "#";

	@Inject
	private LoginControlador loginUsuario;

	public LoadTreeMenuControlador() {
	}

	@PostConstruct
	public void init() {
		//System.out.println("Usuario: " + loginUsuario.getUserName() + " --- Perfil: "+ loginUsuario.getPerfil());
		items = itemsServicio.getAll(loginUsuario.getPerfil());
	}

	public void setMenuHtml(String menuHtml) {
		this.menuHtml = menuHtml;
	}

	public String getMenuHtml() {
		return this.createMenu();
		// return this.readXml();
	}

	public void setXmlTemplate(String xmlTemplate) {
		this.xmlTemplate = xmlTemplate;
	}

	public String getXmlTemplate() {
		return xmlTemplate;
	}

	public List<RhGlbOpcionesMenu> getOpciones() {
		return opciones;
	}

	/**
	 * Lee el archivo xml del menu y lo pasa a la vista para crear el arbol
	 * 
	 * @return String[]
	 */
	public String[] readXml() {
		String menu[] = new String[100];
		try {
			// System.out.println("---------Loading XML Menu--------------");
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			FacesContext ctx = FacesContext.getCurrentInstance();
			String path = ctx.getExternalContext().getRealPath("/") + "resources/senaguaConfigData/treeMenu.xml";
			// System.out.println("El path es: " + path);

			@SuppressWarnings("unused")
			FacesContext facesContext = FacesContext.getCurrentInstance();
			Document doc = docBuilder.parse(new File(path));
			// normalizar el texto para mostrarlo adecuadamente
			doc.getDocumentElement().normalize();
			// System.out.println ("Lectura de xml para menu de arbol: " +
			// doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("item");
			int temp = 0;
			menu[temp] = "\n<ul id=\"tree\">";
			for (temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					// Crear un arreglo con la jerarquia del menu
					// verificar si tiene padre o es nodo nuevo
					String submenu = "";
					Boolean link = true;
					if (!getTagValue("submenuFile", eElement).equals(this.escape)) {
						submenu = this.getSubMenu(getTagValue("submenuFile",eElement));
						link = false;
					}
					menu[temp + 1] = "\n<li>";
					if (link) {
						menu[temp + 1] += "<a onclick=\"sendPage('null','../private/" + getTagValue("ref", eElement) + "','deploy');\">";
						menu[temp + 1] += getTagValue("label", eElement);
						menu[temp + 1] += "</a>";
					} else {
						menu[temp + 1] += "<span>" + getTagValue("label", eElement) + "</span>";
					}
					menu[temp + 1] += submenu + "</li>";
				}
			}
			menu[temp + 1] = "\n</ul>";
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}

		return menu;
	}

	public String createMenu() {
		String menu = "";
		try {
			menu = "\n<ul id=\"tree\">";
			for (RhGlbPermisosOpcionesMenuPerfil opt : items) {
				
				// verificar si tiene padre o es nodo nuevo
				if (( opt.getRhGlbOpcionesMenu().getOpcCodigo() % 1000000 == 0)
						&& (opt.getRhGlbOpcionesMenu().getOpcUrl().equals("#")) ) {
					// es NODO PADRE
					menu += "<li><span>" + opt.getRhGlbOpcionesMenu().getOpcNombre() + "</span><ul>";
					List<RhGlbPermisosOpcionesMenuPerfil> submenus = itemsServicio
							.getSubMenu(loginUsuario.getPerfil(), opt.getRhGlbOpcionesMenu().getOpcCodigo(), 1000000);
					for (RhGlbPermisosOpcionesMenuPerfil sub : submenus) {
						// verificar si es subnodo o link
						if ((sub.getRhGlbOpcionesMenu().getOpcCodigo() % 1000 == 0)
								&& (sub.getRhGlbOpcionesMenu().getOpcUrl().equals("#"))) {
							// es SUBMENU
							menu += "<li><span>" + sub.getRhGlbOpcionesMenu().getOpcNombre()
									+ "</span><ul>";
							List<RhGlbPermisosOpcionesMenuPerfil> links = itemsServicio
									.getSubMenu(loginUsuario.getPerfil(), sub.getRhGlbOpcionesMenu().getOpcCodigo(), 1000);
							for (RhGlbPermisosOpcionesMenuPerfil lnk : links) {
								if ((lnk.getRhGlbOpcionesMenu().getOpcCodigo() % 1000 != 0)
										&& (!lnk.getRhGlbOpcionesMenu().getOpcUrl().equals("#"))) {
									menu += "<li><a onclick=\"sendPage('null','"
											+ lnk.getRhGlbOpcionesMenu().getOpcUrl()
											+ "','deploy');\">"
											+ lnk.getRhGlbOpcionesMenu().getOpcNombre() + "</a></li>";
								}
							}
							menu += "</ul></li>";
						} else if ((sub.getRhGlbOpcionesMenu().getOpcCodigo() % 1000 == 0)
								&& (!sub.getRhGlbOpcionesMenu().getOpcUrl().equals("#"))) {
							// es LINK
							menu += "<li><a onclick=\"sendPage('null','"
									+ sub.getRhGlbOpcionesMenu().getOpcUrl() + "','deploy');\">"
									+ sub.getRhGlbOpcionesMenu().getOpcNombre() + "</a></li>";
						}
					}
					menu += "</ul></li>";
				} else if ((opt.getRhGlbOpcionesMenu().getOpcCodigo() % 1000000 == 0)
						&& (!opt.getRhGlbOpcionesMenu().getOpcUrl().equals("#"))) {
					// es LINK
					menu += "<li><a onclick=\"sendPage('null','"
							+ opt.getRhGlbOpcionesMenu().getOpcUrl() + "','deploy');\">"
							+ opt.getRhGlbOpcionesMenu().getOpcNombre() + "</a></li>";
				}
			}
			menu += "\n</ul>";
		} catch (Exception e) {
			System.out.println("Error en la creación del menu: " + e);
		}
		// System.out.println(menu);
		return menu;
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}

	/**
	 * Obtiene el submenu del xml que corresponde
	 * 
	 * @param tagName
	 * @return String
	 */
	private String getSubMenu(String tagName) {

		try {
			// System.out.println("LOADING SUBMENU : " + tagName);
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			FacesContext ctx = FacesContext.getCurrentInstance();
			String path = ctx.getExternalContext().getRealPath("/")
					+ "resources/senaguaConfigData/" + tagName;

			Document doc = docBuilder.parse(new File(path));

			doc.getDocumentElement().normalize();

			// System.out.println ("Lectura de xml para sub-menu de arbol: " +
			// doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("item");

			String subMenu = "<ul>";

			// leer los submenus recursivamente

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					// Crear un arreglo con la jerarquia del menu
					// verificar si tiene padre o es nodo nuevo
					String submenuInter = "";
					Boolean link = true;
					if (!getTagValue("submenuFile", eElement).equals(
							this.escape)) {
						submenuInter = this.getSubMenu(getTagValue(
								"submenuFile", eElement));
						link = false;
					}

					// String submenu =

					subMenu += "\n<li>";
					if (link) {
						subMenu += "<a onclick=\"sendPage('null','../private/"
								+ getTagValue("ref", eElement)
								+ "','deploy');\">"
								+ getTagValue("label", eElement) + "</a>";
					} else {
						subMenu += "<span>" + getTagValue("label", eElement)
								+ "</span>";
					}
					subMenu += submenuInter;
					subMenu += "</li>";
				}
			}

			subMenu += "</ul>";

			return subMenu;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
			return null;
		}
	}

}