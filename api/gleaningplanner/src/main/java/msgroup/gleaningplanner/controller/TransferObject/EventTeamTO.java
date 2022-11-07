package msgroup.gleaningplanner.controller.TransferObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import msgroup.gleaningplanner.model.Comment;
import msgroup.gleaningplanner.model.Event;
import msgroup.gleaningplanner.model.Farm;
import msgroup.gleaningplanner.model.GleanerGroup;
import msgroup.gleaningplanner.model.Organization;
import msgroup.gleaningplanner.model.Producer;
import msgroup.gleaningplanner.model.Volunteer;

public class EventTeamTO {

    public Event event;
    public Producer producer;
    public Farm farm;
    public List<EventTeam> teams = new ArrayList<EventTeam>();
    public Set<Organization> organizations = new HashSet<>();
    public Set<GleanerGroup> gleanerGroups = new HashSet<>();
    public List<Comment> comments;


    public static class EventTeam{
        public Integer teamNumber;
        public Boolean isTeamAccepted;
        public Set<Volunteer> volunteers = new HashSet<>();


        public void setIsTeamAccepted(boolean isTeamAccepted) {
            this.isTeamAccepted = isTeamAccepted;
        }
    }
}
