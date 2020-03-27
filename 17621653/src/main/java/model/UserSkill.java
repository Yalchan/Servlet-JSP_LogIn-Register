package model;

import enums.TypeSkill;

public class UserSkill {
	private String skillName;
	private TypeSkill skillType;
	
	public UserSkill(String skillName, TypeSkill skillType) {
		super();
		this.skillName = skillName;
		this.skillType = skillType;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public TypeSkill getSkillType() {
		return skillType;
	}

	public void setSkillType(TypeSkill skillType) {
		this.skillType = skillType;
	}
	

}
