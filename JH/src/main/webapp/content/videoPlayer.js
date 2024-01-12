// const API_URL = `http://localhost:8080`;
// // alert("test");
//
// // uses FETCH web api
// // https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
// //
// //
// function fetchActivitiesData() {
//   fetch(`${API_URL}/api/videos`)
//     .then(res => {
//       return res.json();
//     })
//     .then(data => {
//       showVideoList(data);
//     })
//     .catch(error => {
//       console.log(`Error Fetching data : ${error}`);
//       document.getElementById('videos').innerHTML = 'Error Loading Data';
//     });
// }
//
// function showVideoList(data) {
//   // the data parameter will be a JS array of JS objects
//   // this uses a combination of "HTML building" DOM methods (the document createElements) and
//   // simple string interpolation (see the 'a' tag on title)
//   // both are valid ways of building the html.
//   const activities = document.getElementById('videos');
//   const list = document.createDocumentFragment();
//
//   data.map(function (videos) {
//     let div = document.createElement('div');
//     let title = document.createElement('h3');
//
//     title.innerHTML = `<a href="details.html?videoid=${videos.id}">${video.videoURL}</a>`;
//
//     div.appendChild(title);
//     list.appendChild(div);
//   });
//
//   activities.appendChild(list);
// }
//
// function handlePage() {
//   console.log('load all videos');
//   fetchActivitiesData();
// }
//
// handlePage();
