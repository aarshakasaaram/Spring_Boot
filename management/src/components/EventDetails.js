import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Container, Row, Col, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import base_url from './../api/bootapi';

const EventDetails = () => {
  const { id } = useParams();
  const [event, setEvent] = useState(null);
  const [users, setUsers] = useState([]);
  const [category, setCategory] = useState('');

  useEffect(() => {
    axios.get(`${base_url}/events/${id}`)
      .then(response => setEvent(response.data))
      .catch(error => console.error(error));
  }, [id]);

  const fetchUsers = (role) => {
    setCategory(role);
    axios.get(`${base_url}/users?role=${role}&eventId=${id}`)
      .then(response => setUsers(response.data))
      .catch(error => console.error(error));
  };

  return (
    <Container className="mt-4">
      {event && (
        <Row>
          <Col md={6}>
            <h2>{event.eventname}</h2>
            <p>{event.description}</p>
          </Col>
          <Col md={6}>
            <Button onClick={() => fetchUsers('organizer')}>Organizers</Button>
            <Button onClick={() => fetchUsers('speaker')}>Speakers</Button>
            <Button onClick={() => fetchUsers('attendee')}>Attendees</Button>
            <ul>
              {users.map(user => (
                <li key={user.id}>{user.name}</li>
              ))}
            </ul>
          </Col>
        </Row>
      )}
    </Container>
  );
};

export default EventDetails;