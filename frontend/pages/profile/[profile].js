import Head from "next/head";
import { useRouter } from "next/router";
import { useState, useEffect } from "react";

import ProfilePage from "../../components/Profiles/ProfilePage";

export default function Profile(props) {
  
  const [ pageInfo, setPageInfo ] = useState({});
  const [ passedData, setPassedData ] = useState({});
  const [ commentData, setCommentData ] = useState([]);
  const router = useRouter();

  useEffect(() => {
    setPageInfo(router.query)
    if (router.query) {
      getDataFromServer(router.query);
    }
  }, [router.query]);


  async function getDataFromServer(data) {
    const out = {
      "ID": data.profile,
    }
    console.log(out);

    let response = null;
    try {
        response = await fetch(`http://localhost:8080/${data.type}/get-by-filter`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json", 
        },
        body: JSON.stringify(out)
      });
      response = await response.json();
    }catch(e) {
      console.log(e);
    }

    let incoming = null;
    if (response) {
      incoming = response[data.type][0];
    }else return;

    let comments = null;
    try { 
      comments = await fetch(`http://localhost:8080/comment/getall`, { 
        method: 'GET',
        headers: {
          "Content-Type": "application/json"
        }
      });
      comments = await comments.json();
      console.log(comments);
    }catch(e) {
      console.log(e);
    }
    
    setPassedData({
      ID: incoming.ID,
      username: incoming.username,
      postalCode: incoming.postalCode,
      address: incoming.address,
      city: incoming.city,
      firstName: incoming.firstName,
      lastName: incoming.lastName,
      email: incoming.email,
      personType: data.type,
      name: data.name
    });
    
    let incomingComments = null;
    if (comments) {
      incomingComments = comments["comments"]; // this is a list of comment objects
    }else return;

    setCommentData(incomingComments);

  }



    return (
      <div key={pageInfo.pid}>
        <Head>
          <title>Title</title>
          <meta name="description" content="Generated by create next app" />
          <meta name="viewport" content="width=device-width, initial-scale=1" />
          <link rel="icon" href="/favicon.ico" />
        </Head>
  

        <main>
          <ProfilePage comments={commentData} info={passedData} /> 
        </main>
      </div>
    );
  }
  