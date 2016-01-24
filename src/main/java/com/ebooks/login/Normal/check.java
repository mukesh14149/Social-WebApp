//For practise purpose.
package com.ebooks.login.Normal;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ebooks.timeline.database.timeline;

public class check {
	class Edge implements Comparable<Edge>
    {
        HashMap<Integer,Integer> src, dest; 
        int weight;
 
        // Comparator function used for sorting edges based on
        // their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };
 
    // A class to represent a subset for union-find
    
	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	int V, E;    // V-> no. of vertices & E->no.of edges
    Edge edge[];
	check(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
	public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
	// TODO Auto-generated method stub
		check graph=new check(6,5);
		
        
	}

}
