
public class Room {
	private String description;
	private Boolean isBossRoom;
	private Boolean isCurrent;
	private Boolean treasureRoom;
	private Boolean cleared;
	private Boolean isWall=false;


	//Compiles a new room
	public Room(String description){
		this.description = description;
		this.isBossRoom = false;
		this.isCurrent = false;
		this.treasureRoom = false;
		this.cleared = false;

	}
	public void setIsWall(boolean b){
		isWall = b;
	}

    public boolean isaWall(){
        return isWall;
    }

    public boolean isaRoom(){
        if(isaWall()){
            return false;
        } else{
            return true;
        }
    }

	public void setIsCurrent(Boolean b){
		isCurrent = b;

	}
	public boolean isCurrent(){
		return isCurrent;
	}

	public boolean isTreasureRoom(){
		return treasureRoom;
	}

	public boolean isBossRoom(){return isBossRoom;}

	public void setBossRoom(Boolean b){
		isBossRoom=b;
	}

	public void setTreasureRoom(Boolean b){
		treasureRoom=b;

	}

	public boolean isCleared(){
		return cleared;
	}

	public void setCleared(Boolean b){
		cleared=b;
	}




}
