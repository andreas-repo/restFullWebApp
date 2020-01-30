package com.gepardec;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ApplicationPath("rest")
public class ApplicationResource extends Application{
}
