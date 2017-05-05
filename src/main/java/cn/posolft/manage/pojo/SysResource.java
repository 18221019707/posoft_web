package cn.posolft.manage.pojo;

import java.util.List;

/**
 * @author Galen.Zhou
 */
public class SysResource{
    private String id;

    private String name;

    private String url;

    private String memo;

    private String parentId;

    private String resLevel;

    private String depUrl;
    
    private List<SysResource> sons;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getResLevel() {
        return resLevel;
    }

    public void setResLevel(String resLevel) {
        this.resLevel = resLevel == null ? null : resLevel.trim();
    }

    public String getDepUrl() {
        return depUrl;
    }

    public void setDepUrl(String depUrl) {
        this.depUrl = depUrl == null ? null : depUrl.trim();
    }

	public List<SysResource> getSons() {
		return sons;
	}

	public void setSons(List<SysResource> sons) {
		this.sons = sons;
	}
    
    
}