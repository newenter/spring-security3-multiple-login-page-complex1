/**
 * 
 */
package src.org.lhp.security.lusrmgr.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TODO 资源
 * 
 * @Title : Resource.java
 * @author liheping 2012-4-11 下午04:30:14
 * @version : V1.0 2012-4-11
 * @Copyright : Copyright ( c ) dev.liheping.org ,2012
 */
@Entity
@Table(name = "SYS_RESOURCE")
public class Resource extends SecurityBaseEntity implements Serializable {
	private static final long serialVersionUID = 464301232263073940L;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;// 资源名称

	@Column(name = "CODE", unique = true, nullable = false)
	private String code;// 资源编码

	@Column(name = "URI", unique = true, nullable = false)
	private String URI;// 资源URI

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	private ResourceType type;// 资源类型

	@Column(name = "LEVEL", nullable = false)
	private int level; // 资源级别

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_ID")
	private Resource parent; // 父节点

	@OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private Set<Resource> children; // 子节点

	@ManyToMany(fetch = FetchType.LAZY, targetEntity = Authority.class, mappedBy = "resources")
	private Set<Authority> authoritys; // 权限

	// ============================//

	public String getName() {
		return name;
	}

	public Resource(String name, String code, String uRI, ResourceType type,
			String description, int level, boolean enabled, Resource parent,
			Set<Resource> children) {
		super();
		this.name = name;
		this.code = code;
		URI = uRI;
		this.type = type;
		this.description = description;
		this.level = level;
		this.enabled = enabled;
		this.parent = parent;
		this.children = children;
	}

	public Resource() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}

	public Set<Resource> getChildren() {
		return children;
	}

	public void setChildren(Set<Resource> children) {
		this.children = children;
	}

	public Set<Authority> getAuthoritys() {
		return authoritys;
	}

	public void setAuthoritys(Set<Authority> authoritys) {
		this.authoritys = authoritys;
	}

}
