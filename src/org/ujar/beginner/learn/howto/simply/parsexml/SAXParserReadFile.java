/*
 *     Copyright 2021 uJar Boot Camp @ http://ujar.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ujar.beginner.learn.howto.simply.parsexml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserReadFile {

  public static void main(String argv[]) {

    try {

      SAXParserFactory factory = SAXParserFactory.newInstance();
      SAXParser saxParser = factory.newSAXParser();

      DefaultHandler handler = new DefaultHandler() {

        boolean bfname = false;
        boolean blname = false;
        boolean bnname = false;
        boolean bsalary = false;

        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {

          System.out.println("Start Element :" + qName);

          if (qName.equalsIgnoreCase("FIRSTNAME")) {
            bfname = true;
          }

          if (qName.equalsIgnoreCase("LASTNAME")) {
            blname = true;
          }

          if (qName.equalsIgnoreCase("NICKNAME")) {
            bnname = true;
          }

          if (qName.equalsIgnoreCase("SALARY")) {
            bsalary = true;
          }

        }

        public void endElement(String uri, String localName,
                               String qName) throws SAXException {

          System.out.println("End Element :" + qName);

        }

        public void characters(char ch[], int start, int length) throws SAXException {

          if (bfname) {
            System.out.println("First Name : " + new String(ch, start, length));
            bfname = false;
          }

          if (blname) {
            System.out.println("Last Name : " + new String(ch, start, length));
            blname = false;
          }

          if (bnname) {
            System.out.println("Nick Name : " + new String(ch, start, length));
            bnname = false;
          }

          if (bsalary) {
            System.out.println("Salary : " + new String(ch, start, length));
            bsalary = false;
          }

        }

      };

      saxParser.parse("src/org/ujar/learn/howto/simply/parsexml/company.xml", handler);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}
