package com.curseproject.alex.requestparser.manager;

import com.curseproject.alex.requestparser.model.Info;
import com.curseproject.alex.requestparser.model.Response;

import java.util.List;

public interface InfoProcessor {
    Response processInfo(List<Info> info);
}
