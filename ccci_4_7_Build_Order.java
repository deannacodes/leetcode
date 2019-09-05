import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;

class Project {
    String id;
    Status status;
    ArrayList<Project> dependencies;
    public Project(String id) {
        this.id = id;
        this.status = Status.QUEUED;
        this.dependencies = new ArrayList<>();
    }
}

enum Status { QUEUED, PENDING, BUILT }


class Main {
    public static void main(String[ ] args) {
        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");
        Project[] projects = {a,b,c,d,e,f};

        Pair<Project, Project> p1 = new Pair(a, d);
        Pair<Project, Project> p2 = new Pair(f, b);
        Pair<Project, Project> p3 = new Pair(b, d);
        Pair<Project, Project> p4 = new Pair(f, a);
        Pair<Project, Project> p5 = new Pair(d, c);

        ArrayList<Pair<Project, Project>> dependencies = new ArrayList<>();
        dependencies.add(p1);
        dependencies.add(p2);
        dependencies.add(p3);
        dependencies.add(p4);
        dependencies.add(p5);

        Project[] result = buildProjects(projects, dependencies);

        if (result == null) {
            System.out.println("No Solution");
        } else {
            for (Project pp : result) {
                System.out.print(pp.id + ", ");
            }
        }
    }

    public static Project[] buildProjects(Project[] projects, ArrayList<Pair<Project, Project>> dependencies) {
        LinkedList<Project> queue = new LinkedList<>();
        Project[] order = new Project[projects.length];
        int i = 0;
        Project loopFlag = null;

        for (Pair <Project, Project> dependency : dependencies) {
            Project me = dependency.getValue();
            Project dep = dependency.getKey();
            if (me.id == dep.id) return null;
            me.dependencies.add(dep);
        }
        for (Project p : projects) {
            queue.add(p);
        }

        while(!queue.isEmpty()) {
            Project p = queue.poll();
            boolean build = true;
            boolean allPending = true;

            for (Project d : p.dependencies) {
                if (d.status != Status.BUILT) build = false;
                if (d.status != Status.PENDING) allPending = false;
            }

            if (build) {
                p.status = Status.BUILT;
                order[i++] = p;
                if (p == loopFlag) loopFlag = null;
            } else if (loopFlag == p) {
                return null;
            } else {
                p.status = Status.PENDING;
                queue.add(p);
            }

            if (loopFlag == null && p.status == Status.PENDING && allPending) loopFlag = p;

        }

        return order;

    }

}

