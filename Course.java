
package Advising_System;

public class Course {
private String name; 
private int sec;
private String faculty;
private String roomNo;
private int[] startTime = new int[3];
private int[] endTime = new int[3];

    public Course(String name, int sec, String faculty, String roomNo, int[] startTime, int[] endTime) {
        this.name = name;
        this.sec = sec;
        this.faculty = faculty;
        this.roomNo = roomNo;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public int getSec() {
        return sec;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public int[] getStartTime() {
        return startTime;
    }

    public int[] getEndTime() {
        return endTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public void setStartTime(int[] startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int[] endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Course Info" + "\nname=" + name +"."+ sec + " \nFaculty=" + faculty + "\nRoom No=" + roomNo + "Start Time=" + startTime + "\nEnd Time=" + endTime ;
    }



}
